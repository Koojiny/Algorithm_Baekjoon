import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int idx = 0;
        int targetLength = number.length() - k;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < targetLength; i++) {
            char max = '0';
            
            for (int j = idx; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
                if (max == '9') break;
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}