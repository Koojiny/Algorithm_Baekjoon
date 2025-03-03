import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 큐에 넣고 앞에서부터 하나씩 빼기 (가격 비교)
        
        // 1. 큐 초기화 후 배열 넣기
        int[] answer = new int[prices.length]; // 정답 배열 크기 초기화
        Queue<Integer> q = new LinkedList<>(); // 큐 초기화
        
        for (int i : prices) { // 큐에 배열 내 숫자 전부 삽입
            q.add(i);
        }
        
        // 2. 큐 내에 값이 있을때까지 반복 - 첫 번째 가격을 꺼낸 후 뒤에 숫자 계속 비교
        int idx = 0;        
        while (!q.isEmpty()) { // 큐 안에 주식가격 있을 때까지 진행
            int curPrice = q.poll();
            
            // curPrice 다음 숫자부터 반복문 진행하며 주식가격 비교
            for (int i = (prices.length - q.size()); i < prices.length; i++) {
                // 주식 가격이 떨어졌을 경우
                if (curPrice > prices[i]) {
                    answer[idx]++;
                    break;
                }
                // 주식 가격이 그대로이거나 오른 경우
                if (curPrice <= prices[i]) {
                    answer[idx]++;
                }
            }
            idx++; // for문이 한번 끝나면 인덱스 +1
        }
                
        return answer;
    }
}