class Solution {
    public int solution(int n) {
        int temp = n + 1;
        int zeroCnt = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') zeroCnt++;
        }

        while (true) {
            int zeroTemp = 0;
            String tempNum = Integer.toBinaryString(temp);

            for (int j = 0; j < tempNum.length(); j++) {
                if (tempNum.charAt(j) == '1') zeroTemp++;
            }
            
            if (zeroCnt == zeroTemp) break;
            temp++;
        }
        
        return temp;
    }
}