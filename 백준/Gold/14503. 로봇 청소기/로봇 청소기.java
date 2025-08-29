import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int r, c, d, cleanCnt;
    public static int[][] room;
    public static int[] dx = {-1, 0, 1, 0}; //0북 1동 2남 3서
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(r, c);

        System.out.println(cleanCnt);
    }

    public static void simulation(int x, int y) {
        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸 청소
        if (room[x][y] == 0) {
            room[x][y] = 2;
            cleanCnt++;
        }

        // 현재 칸의 주변 4칸 확인
        boolean notCleaned = false;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (inRange(nx, ny) && room[nx][ny] == 0) {
                notCleaned = true;
            }
        }

        // 4칸 중 청소되지 않은 칸이 있는 경우 -> 반시계방향 90도 회전, d 방향 기준 앞 한칸 청소되지 않았다면 한 칸 전진
        if (notCleaned) {
            d = (d + 3) % 4;
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if (room[nextX][nextY] == 0) {
                simulation(nextX, nextY);
            } else {
                simulation(x, y);
            }
        } else { // 빈 칸 없는 경우 -> 방향 유지, 한 칸 후진 된다면 후진 / 뒤쪽이 벽이라 후진 안된다면 멈춤
            int tempD = (d + 2) % 4;
            int nextX = x + dx[tempD];
            int nextY = y + dy[tempD];
            if (inRange(nextX, nextY) && room[nextX][nextY] != 1) {
                simulation(nextX, nextY);
            } else {
                return;
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
