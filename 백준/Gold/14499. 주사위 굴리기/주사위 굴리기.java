import java.io.*;
import java.util.*;

public class Main {
    public static int[] dice = new int[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dx = {0, 0, -1, 1}; // 동 서 북 남
        int[] dy = {1, -1, 0, 0};

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            int nx = x + dx[cmd - 1];
            int ny = y + dy[cmd - 1];

            // 범위 체크
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            // 주사위 굴리기
            rollDice(cmd);

            x = nx;
            y = ny;

            // 보드와 주사위 값 교환
            if (board[x][y] == 0) {
                board[x][y] = dice[1];
            } else {
                dice[1] = board[x][y];
                board[x][y] = 0;
            }

            System.out.println(dice[0]);
        }
    }

    public static void rollDice(int cmd) {
        int top = dice[0];
        int bottom = dice[1];
        int north = dice[2];
        int south = dice[3];
        int west = dice[4];
        int east = dice[5];

        if (cmd == 1) { // 동
            dice[0] = west;
            dice[1] = east;
            dice[4] = bottom;
            dice[5] = top;
        } else if (cmd == 2) { // 서
            dice[0] = east;
            dice[1] = west;
            dice[4] = top;
            dice[5] = bottom;
        } else if (cmd == 3) { // 북
            dice[0] = south;
            dice[1] = north;
            dice[2] = top;
            dice[3] = bottom;
        } else if (cmd == 4) { // 남
            dice[0] = north;
            dice[1] = south;
            dice[2] = bottom;
            dice[3] = top;
        }
    }
}
