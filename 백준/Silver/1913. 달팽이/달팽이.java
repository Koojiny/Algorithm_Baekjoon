import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int tmpRow = 0; // 시작 행
        int tmpCol = 0; // 시작 열
        int value = n * n;  // 1부터 시작
        int[] dx = {1, 0,-1, 0};
        int[] dy = {0, 1, 0, -1}; // 아래, 오른쪽, 위, 왼쪽 순서로 진행
        int direction = 0; // 방향 설정
        int targetRow = 0;
        int targetCol = 0;

        while (value > 0) {
            arr[tmpRow][tmpCol] = value--;
            if (arr[tmpRow][tmpCol] == target) {
                targetRow = tmpRow + 1;
                targetCol = tmpCol + 1;
            }

            int nx = tmpRow + dx[direction];
            int ny = tmpCol + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                direction = (direction + 1) % 4; // 범위 벗어나거나 값이 있는 경우 방향 전환
                nx = tmpRow + dx[direction];
                ny = tmpCol + dy[direction];
            }

            tmpRow = nx;
            tmpCol = ny;
        }

        //System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(targetRow + " " + targetCol);
    }
}
