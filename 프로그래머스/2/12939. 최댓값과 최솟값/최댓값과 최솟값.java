import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int n = st.countTokens();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        
        return arr[0] + " " + arr[arr.length - 1];
    }
}