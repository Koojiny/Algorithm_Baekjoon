import java.io.*;
import java.util.*;

public class Main {

    public static boolean[][] visit;
    public static int[][] board;
    public static Queue<int[]> q = new LinkedList<>();
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int maxSize, count; // 가장 넓은 것의 넓이, 그림 개수
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        board = new int[n][m];
        visit = new boolean[n][m];

        // 보드 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static void bfs(int y, int x) {
        int size = 1;
        q.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int k = 0; k < 4; k++) {
                int ny = cy + dy[k];
                int nx = cx + dx[k];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && !visit[ny][nx] && board[ny][nx] == 1) {
                    q.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                    size++;
                }
            }
        }

        if (size > maxSize) maxSize = size;
    }
}
