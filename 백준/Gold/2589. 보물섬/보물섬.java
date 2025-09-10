import java.io.*;
import java.util.*;

public class Main {
    public static char[][] map;
    public static int sero, garo;
    public static int max;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sero = Integer.parseInt(st.nextToken());
        garo = Integer.parseInt(st.nextToken());
        map = new char[sero][garo];

        for (int i = 0; i < sero; i++) {
            String s = br.readLine();
            for (int j = 0; j < garo; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        max = 0;
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        boolean[][] visited = new boolean[sero][garo];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2];
            max = Math.max(max, dist);

            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    q.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < sero && 0 <= y && y < garo;
    }
}
