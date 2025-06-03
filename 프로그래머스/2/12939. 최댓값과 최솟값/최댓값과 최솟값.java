import java.util.*;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (now < min) min = now;
            if (now > max) max = now;
        }
        
        return min + " " + max;
    }
}