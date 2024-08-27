import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int n = st.countTokens();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        answer = arr[0] + " " + arr[arr.length - 1];
        return answer;
    }
}