import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] miro, dist;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(str.substring(j, j + 1));
                dist[i][j] = -1;
            }
        }

        bfs();

        System.out.println(dist[n - 1][m - 1]);
    }

    public static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (inRange(nx, ny) && dist[nx][ny] == -1) {
                    if (miro[nx][ny] == 0) {
                        dq.addFirst(new int[]{nx, ny});
                        dist[nx][ny] = dist[curX][curY];
                    } else {
                        dq.addLast(new int[]{nx, ny});
                        dist[nx][ny] = dist[curX][curY] + 1;
                    }
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
