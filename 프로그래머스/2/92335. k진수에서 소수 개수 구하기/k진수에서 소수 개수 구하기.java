import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // 진법 변환
        String num = Integer.toString(n, k);
        
        // 0 기준으로 split 후 리스트에 넣기 (10001일 경우 ""도 포함될 수 있음)
        String[] arr = num.split("0");

        // list 순회하면서 소수 판별
        for (int i = 0; i < arr.length; i++) {
            if (checkSosu(arr[i])) answer++;
        }
        
        return answer;
    }
    
    public static boolean checkSosu(String s) {
        if (s.equals("")) return false;
        
        Long tmpNum = Long.parseLong(s);
        
        if (tmpNum <= 1) return false;
        else {
            for (int i = 2; i <= Math.sqrt(tmpNum); i++) {
                if (tmpNum % i == 0) return false;
            }
        }
        
        return true;
    }
}