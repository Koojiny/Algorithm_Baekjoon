import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zeroCnt = 0;
        int cnt = 0;
        // long num = Integer.parseInt(s);
        
        while (s.length() > 1) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeroCnt++;
                else sb.append(s.charAt(i));
            }
            System.out.println(sb);
            s = Integer.toBinaryString(sb.toString().length());

            // num = cal(sb.toString().length());
            // s = String.valueOf(num);
            cnt++;
        }
        
        System.out.println(cnt);
        System.out.println(zeroCnt);
        answer[0] = cnt;
        answer[1] = zeroCnt;
        return answer;
    }
    
    public int cal(int num) { 
        int temp = num;
        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            temp /= 2;
            sb.append(num % 2);
            num = temp;
        }
        
        String tempStr = sb.reverse().toString();

        return Integer.parseInt(tempStr);
    }
}