import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // Key-Value 활용 (HashMap)        
        Map<String, Integer> inTimeMap = new HashMap<>(); // 차량번호, 입차시간
        Map<String, Integer> totalTimeMap = new HashMap<>(); // 차량번호, 누적주차시간
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            int time = convertToMin(st.nextToken()); // 차량 입출차 시간 (분으로 변환)
            String carNum = st.nextToken(); // 차량번호
            String inOut = st.nextToken(); // 입출차 확인
            
            if (inOut.equals("IN")) { // 입차
                inTimeMap.put(carNum, time);
            } else { // 출차
                int inTime = inTimeMap.get(carNum);
                int parkingTime = time - inTime;
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkingTime);
                inTimeMap.remove(carNum); // 입차 기록에서 제거
            }
        }
        
        for (String carNum : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNum);
            int parkingTime = convertToMin("23:59") - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkingTime);
        }
        
        // 차량 번호 오름차순 정렬
        List<String> carList = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carList);
        
        int[] answer = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            String carNum = carList.get(i);
            int totalTime = totalTimeMap.get(carNum);
            answer[i] = calFee(totalTime, fees);
        }
        return answer;
    }
    
    // 시간을 분으로 변환
    public int convertToMin(String time) {
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int min = Integer.parseInt(splitTime[1]);
        
        return hour * 60 + min;
    }
    
    // 주차 요금 계산
    public int calFee(int totalTime, int[] fees) {
        int sTime = fees[0]; // 기본 시간
        int sFee = fees[1]; // 기본 요금
        int sMin = fees[2]; // 단위 시간
        int sMinFee = fees[3]; // 단위 요금
        
        if (totalTime <= sTime) {
            return sFee;
        } else {
            int extraTime = totalTime - sTime;
            int extraFee = (int) Math.ceil((double)extraTime / sMin) * sMinFee;
            
            return sFee+ extraFee;
        }
    }
}