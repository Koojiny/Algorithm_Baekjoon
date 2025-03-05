import java.util.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1); // 공백 포함하여 분리
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1).toLowerCase();
            }
            answer.append(words[i]);
            if (i < words.length - 1) {
                answer.append(" "); // 단어 사이 공백 유지
            }
        }
        
        return answer.toString();
    }
}