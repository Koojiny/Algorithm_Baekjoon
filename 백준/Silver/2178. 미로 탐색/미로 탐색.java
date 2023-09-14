import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(miro[N - 1][M - 1]);
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int now[] = q.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = now[0] + dx[k];
                int nextY = now[1] + dy[k];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (visited[nextX][nextY]) continue;
                if (miro[nextX][nextY] != 0) {
                    visited[nextX][nextY] = true;
                    miro[nextX][nextY] = miro[now[0]][now[1]] + 1;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }
    }
}