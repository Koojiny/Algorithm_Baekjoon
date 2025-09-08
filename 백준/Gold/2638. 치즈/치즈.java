import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] paper;
    public static boolean[][] air;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static boolean canMelt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            // 외부 공기 체크
            findOutside();

            // 녹이기
            canMelt = false;
            meltCheese();
            if (!canMelt) break;

            // 시간 더하기
            time++;
        }

        System.out.println(time);
    }

    public static void findOutside() {
        air = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        air[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (inRange(nx, ny) && !air[nx][ny] && paper[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    air[nx][ny] = true;
                }
            }
        }
    }

    public static void meltCheese() {
        int[][] melt = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] == 1) {
                    int curX = i;
                    int curY = j;
                    int airCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = curX + dx[k];
                        int ny = curY + dy[k];

                        if (inRange(nx, ny) && air[nx][ny]) {
                            airCnt++;
                        }
                    }

                    if (airCnt >= 2) {
                        melt[i][j] = 1;
                        canMelt = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                paper[i][j] = paper[i][j] - melt[i][j];
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
