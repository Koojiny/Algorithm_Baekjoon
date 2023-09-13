import java.io.*;
import java.util.*;

public class Main {

    static int n, m, cnt, max;
    static int[][] board;
    static boolean[][] isVis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로 크기
        m = Integer.parseInt(st.nextToken()); // 가로 크기

        board = new int[n][m]; // 도화지 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVis = new boolean[n][m]; // 방문확인 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !isVis[i][j]) { // 그림이 그려져 있거나 방문하지 않은 경우 BFS
                    max = Math.max(max, BFS(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        isVis[x][y] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int d = 0; d < 4; d++) {
                int nx = px + dx[d];
                int ny = py + dy[d];

                if (nx < 0 || ny < 0 || ny > m - 1 || nx > n - 1) continue;
                if (isVis[nx][ny]) continue;
                if (board[nx][ny] == 1) {
                    size++;
                    isVis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return size;
    }
}