import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // Queue<Integer> que = new LinkedList<>();
        // for (int i = 0; i < prices.length; i++) {
        //     que.offer(prices[i]);
        // }
        
        // System.out.println(que);
        
        // int tmp = q.poll();
        
//         while (q.size() > 0) {
//             int time = 0;
//             int next = q.peek();
            
//         }
        
        for (int i = 0; i < prices.length; i++) {
            int tmp = prices[i];
            int time = -1;
            for (int j = i; j < prices.length; j++) {
                if (tmp > prices[j]) {
                    time++;
                    break;
                } else {
                    time++;
                }
            }
            answer[i] = time;
        }
        
        return answer;
    }
}