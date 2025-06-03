import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (stk.size() == 0) stk.push(s.charAt(i));
            else if (stk.size() > 0) {
                char tmp = stk.peek();
                if (tmp == s.charAt(i)) {
                    stk.pop();
                } else {
                    stk.push(s.charAt(i));
                }
            }
        }

        return stk.size() == 0? 1 : 0;
    }
}