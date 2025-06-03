import java.util.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        // System.out.println(Arrays.toString(words));
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1).toLowerCase();
            }
            sb.append(words[i]);
            if (i < words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}