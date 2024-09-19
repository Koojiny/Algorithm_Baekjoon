class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int tmpVal = 1;     // 1부터 값 입력
        int startRow = 0;   // 시작 행
        int endRow = n - 1; // 끝 행
        int startCol = 0;   // 시작 열
        int endCol = n - 1; // 끝 열
        
        while (tmpVal <= n * n) { // tmpVal이 n*n이 될 때까지 반복
            // 1. 왼쪽 -> 오른쪽
            for (int i = startCol; i <= endCol; i++) {
                answer[startRow][i] = tmpVal;
                tmpVal++;
            }
            startRow++;
            
            // 2. 위 -> 아래
            for (int i = startRow; i <= endRow; i++) {
                answer[i][endCol] = tmpVal;
                tmpVal++;
            }
            endCol--;
            
            // 3. 오른쪽 -> 왼쪽
            for (int i = endCol; i >= startCol; i--) {
                answer[endRow][i] = tmpVal;
                tmpVal++;
            }
            endRow--;
            
            // 4. 아래 -> 위
            for (int i = endRow; i >= startRow; i--) {
                answer[i][startCol] = tmpVal;
                tmpVal++;
            }
            startCol++;
        }
        
        return answer;
    }
}