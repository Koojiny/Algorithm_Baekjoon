import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 1. 오름차순 정렬 : 가장 오래 걸리는 심사관 확인
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length - 1] * (long)n; // n명이 가장 오래 걸리는 심사관에게 간 시간
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long pass = 0;
            
            for (int i = 0;i < times.length; i++) {
                pass += mid / times[i];
            }
            // System.out.print("left= "+ left + ", right= "+ right + ", mid=" + mid + ", answer= " + answer + ", pass= " + pass);
            if (pass < n) left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
            // System.out.println(" / left= "+ left + ", right= "+ right + ", mid=" + mid + ", answer= " + answer);
        }        
        
        return answer;
    }
}