import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int len_1 = s1.length;
        int len_2 = s2.length;

        // 공집합 사용을 위해 인덱스 한 줄씩 추가
        int[][] dp = new int[len_1 + 1][len_2 + 1];

        for (int i = 1; i <= len_1 ; i++) {
            for (int j = 1; j <= len_2; j++) {
                // i-1 번째와 j-1 번째 문자가 서로 같다면
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[len_1][len_2]);
    }
}