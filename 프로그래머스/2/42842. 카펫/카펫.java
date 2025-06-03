class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int max = brown + yellow;
        
        for (int i = max; i >= 1; i--) {
            if (max % i != 0) continue;
            int garo = i;
            int sero = max / i;
            int sGaro = garo - 2;
            int sSero = sero - 2;
            
            if (sGaro * sSero == yellow) {
                answer[0] = garo;
                answer[1] = sero;
                break;
            }
        }
        
        return answer;
    }
}