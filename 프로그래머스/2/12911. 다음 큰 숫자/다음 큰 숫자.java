import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int tmpNum = n;
        int cntOne = countOne(n);
        
        while (true) {
            tmpNum++;
            int tmpCntOne = countOne(tmpNum);
            if (tmpCntOne == cntOne) break;
        }
        
        return tmpNum;
    }
    
    public static int countOne(int num) {
        String s = Integer.toBinaryString(num);
        int cntOne = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                cntOne++;
            }
        }
        
        return cntOne;
    }
}