import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] forest;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, find(i, j));
            }
        }

        System.out.println(result);
    }

    public static int find(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y]; // 이미 계산된 경우 값 반환

        int curBamboo = forest[x][y];
        dp[x][y] = 1; // 최소 1일은 생존

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (inRange(nx, ny) && forest[nx][ny] > curBamboo) {
                dp[x][y] = Math.max(dp[x][y], find(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
