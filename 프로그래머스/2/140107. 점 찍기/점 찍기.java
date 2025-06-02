import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            // long y = (long) Math.sqrt(d * d - x * x);
            answer += (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2)) / k + 1;
        }
        
        return answer;
    }
}