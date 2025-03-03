import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 1. 배열 활용? 크기 순 재배열 필요
        // 2. 우선순위 큐 활용? 순서 필요(스코빌 지수 작은 순서대로 자동 재배열 가능)
        // -> 우선순위 큐 사용
        
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : scoville) {
            pq.add(i);
        }
        
        int min = pq.peek();
        while (min < K) { // 가장 작은 스코빌 지수가 K보다 작은 경우 계속해서 진행
            if (pq.size() >= 2) {
                pq.add(pq.poll() + (pq.poll() * 2)); // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            
                min = pq.peek(); // 가장 작은 스코빌 지수 초기화
                answer++;
            } else {
                return -1;
            }
            
        }
        
        return answer;
    }
}