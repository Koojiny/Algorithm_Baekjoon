import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.substring(i, i + 1));
        }

        return sum;
    }
}