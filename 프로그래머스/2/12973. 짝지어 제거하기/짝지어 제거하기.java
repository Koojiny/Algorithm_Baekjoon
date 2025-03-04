import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) { // 문자열 순회
            if (stack.isEmpty()) { // 스택이 비어있는 경우에는 현재 알파벳 삽입
                stack.push(s.charAt(i));
            } else {
                char c = s.charAt(i); // 현재 알파벳
                
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        
        // 문자열 순회가 끝난 후에도 스택이 비어있지 않다면 문자 제거 실패
        return stack.isEmpty() ? 1 : 0;
    }
}