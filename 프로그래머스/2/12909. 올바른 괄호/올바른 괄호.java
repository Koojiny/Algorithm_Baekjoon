import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stk.push(s.charAt(i));
            else {
                if (stk.size() > 0) stk.pop();
                else return false;
            }
        }
        
        if (stk.size() == 0) return true;
        else return false;

    }
}