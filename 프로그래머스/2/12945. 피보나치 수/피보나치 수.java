import java.util.*;

class Solution {
    public int solution(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 0;
        answer[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            answer[i] = (answer[i - 2] + answer[i - 1]) % 1234567;
        }
        
        //System.out.println(Arrays.toString(answer));
        
        return answer[n];
    }
}