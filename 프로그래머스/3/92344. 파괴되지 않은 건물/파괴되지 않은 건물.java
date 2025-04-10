class Solution {    
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] arr = new int[N + 1][M + 1];
        
        // K회 반복하여 누적합 계산할 값을 미리 저장
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if (type == 1) { // 공격
                arr[r1][c1] -= degree;
                arr[r1][c2 + 1] += degree;
                arr[r2 + 1][c1] += degree;
                arr[r2 + 1][c2 + 1] -= degree;
            } else { // 회복
                arr[r1][c1] += degree;
                arr[r1][c2 + 1] -= degree;
                arr[r2 + 1][c1] -= degree;
                arr[r2 + 1][c2 + 1] += degree;
            }
        }
        
        // 누적합 진행 (왼 -> 오)
        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i][j];
            }
        }
        // 누적합 진행 (위 -> 아래)
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j];
            }
        }
        
        // 최종 계산
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + arr[i][j] >= 1) answer++;
            }
        }
        return answer;
    }
}