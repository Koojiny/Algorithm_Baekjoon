import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[][] sea;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int year;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sea = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        year = 0;
        while (true) {
            // 1. 덩어리 개수 확인
            int cnt = countIceberg();
            if (cnt >= 2) break;
            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            // 2. 빙하 녹이기
            meltIceberg();

            // 3. 시간 + 1
            year++;
        }

        System.out.println(year);
    }

    public static int countIceberg() {
        visited = new boolean[n][m];
        int iceCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && sea[i][j] >= 1) {
                    bfs(i , j);
                    iceCnt++;
                }
            }
        }

        return iceCnt;
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];

                if (inRange(nx, ny) && !visited[nx][ny] && sea[nx][ny] >= 1) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void meltIceberg() {
        int[][] melt = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int seaCount = 0;
                if (sea[i][j] > 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if (inRange(nx, ny) && sea[nx][ny] <= 0) {
                            seaCount++;
                        }
                    }
                }
                melt[i][j] = seaCount;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sea[i][j] > 0) {
                    sea[i][j] = Math.max(0, sea[i][j] - melt[i][j]); // ★ 바닥 0
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
