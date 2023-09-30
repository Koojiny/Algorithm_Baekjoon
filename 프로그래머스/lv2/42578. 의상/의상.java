import java.util.*;

class Solution {
     public static int solution(String[][] clothes) {
        // 1. 옷을 종류별로 구분한다
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 입지 않는 경우를 추가해서 모든 조합을 계산
        Iterator<Integer> it = map.values().iterator();
        int answer = 1; // 누적값을 곱하기 위해 1로 시작

        while (it.hasNext()) {
            answer *= it.next().intValue() + 1; // 입지 않은 경우를 위해 1 추가
        }

        // 3. 아무 종류의 옷도 입지 않은 경우를 제외한다
        return answer - 1;
    }
}