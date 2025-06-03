import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCnt = 0;
        
        while (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeroCnt++;
            }
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            count++;
        }
        
        answer[0] = count;
        answer[1] = zeroCnt;
        
        return answer;
    }
}