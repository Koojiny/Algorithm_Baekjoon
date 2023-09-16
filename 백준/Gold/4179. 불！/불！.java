import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] miro;
    static int[][] fire, jihun;
    static Queue<int[]> fQ, jQ;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        miro = new char[R][C];
        fire = new int[R][C];
        jihun = new int[R][C];
        fQ = new LinkedList<>();
        jQ = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                miro[i][j] = s.charAt(j);
                fire[i][j] = -1;
                jihun[i][j] = -1;
                if (miro[i][j] == 'F') { // 불 위치 찾은 경우
                    fQ.offer(new int[]{i, j});
                    fire[i][j] = 0;
                }
                if (miro[i][j] == 'J') { // 지훈이 위치 찾은 경우
                    jQ.offer(new int[]{i, j});
                    jihun[i][j] = 0;
                }
            }
        }

        BFS();

    }

    static void BFS() {
        while (!fQ.isEmpty()) {
            int now[] = fQ.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (fire[nx][ny] >= 0 || miro[nx][ny] == '#' ) continue;
                fire[nx][ny] = fire[now[0]][now[1]] + 1;
                fQ.offer(new int[]{nx, ny});
            }
        }

        while (!jQ.isEmpty()) {
            int now[] = jQ.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) { // 범위를 벗어나면 탈출 성공
                    System.out.println(jihun[now[0]][now[1]] + 1);
                    return;
                }
                if (jihun[nx][ny] >= 0 || miro[nx][ny] == '#') continue;
                if (fire[nx][ny] != -1 && fire[nx][ny] <= jihun[now[0]][now[1]] + 1) continue;
                jihun[nx][ny] = jihun[now[0]][now[1]] + 1;
                jQ.offer(new int[]{nx, ny});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}