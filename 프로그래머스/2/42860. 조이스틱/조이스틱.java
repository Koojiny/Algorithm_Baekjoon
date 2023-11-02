import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int idx = i + 1;
                
                while (idx < name.length() && name.charAt(idx) == 'A') {
                    idx++;
                }
            
                move = Math.min(move, i * 2 + name.length() - idx);
                move = Math.min(move, (name.length() - idx) * 2 + i);
            }
            
        }
        
        return answer + move;
    }
}