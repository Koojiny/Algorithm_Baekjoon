import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int start = 1;
        int end = (n * (n + 1)) / 2;
        int x = -1;
        int y = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) { // 아래
                    x++;
                } else if (i % 3 == 1) { // 오른쪽
                    y++;
                } else if (i % 3 == 2) { // 대각
                    x--;
                    y--;
                }
                
                arr[x][y] = start++;
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        
        int idx = 0;
        int[] answer = new int[end];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}