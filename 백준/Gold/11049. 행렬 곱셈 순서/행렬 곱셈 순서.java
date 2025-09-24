import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] r = new int[N + 1]; // 1..N
        int[] c = new int[N + 1]; // 1..N

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];

        // 길이 2 이상 구간만 채우면 됨 (길이 1은 0)
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i + len - 1 <= N; i++) {
                int j = i + len - 1; // ✅ 오타 수정
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long cost = (long) dp[i][k] + dp[k + 1][j] + (long) r[i] * c[k] * c[j];
                    if (cost < dp[i][j]) dp[i][j] = (int) cost;
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}
