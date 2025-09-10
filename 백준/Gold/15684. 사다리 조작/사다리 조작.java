import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static boolean[][] board;
    static int answer = 4; // 최대 추가 가능 수 + 1

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로선
        M = Integer.parseInt(st.nextToken()); // 가로선
        H = Integer.parseInt(st.nextToken()); // 행 수 (가로선 놓을 수 있는 위치)
        board = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = true; // a행 b열 위치에 가로선 놓기 b, b+1 연결됨
        }

        dfs(0, 1, 1); // count, 시작 행, 시작 열

        System.out.println(answer > 3 ? -1 : answer);
    }

    static void dfs(int count, int x, int y) { // count : 현재까지 추가한 가로선의 수
        if (count >= answer) return;

        if (check()) { // 현재 상태가 유효하면 정답 갱신
            answer = count;
            return;
        }

        // 가로선 추가
        for (int i = x; i <= H; i++) { // 행만큼 진행
            for (int j = 1; j < N; j++) { // 마지막 N에는 우측 세로선이 없으므로 N-1까지 진행
                if (canPlace(i, j)) {
                    board[i][j] = true;
                    dfs(count + 1, i, j + 2);
                    board[i][j] = false;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) { // 세로선
            int col = i;
            for (int j = 1; j <= H; j++) { // 행 확인
                if (board[j][col]) { // 오른쪽으로 이동
                    col++;
                } else if (col > 1 && board[j][col - 1]) { // 왼쪽으로 이동
                    col--;
                }
            }
            // 도착 위치가 시작과 다르면 실패
            if (col != i) return false;
        }

        return true;
    }

    static boolean canPlace(int x, int y) {
        return !board[x][y] && !board[x][y - 1] && !board[x][y + 1];
    }
}
