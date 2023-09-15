import java.io.*;
import java.util.*;

public class Main {

    static int N, M, max;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        checkTomato();
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (box[nx][ny] == 0) {
                    box[nx][ny] = box[now[0]][now[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        }
        System.out.println(max - 1);
    }
}