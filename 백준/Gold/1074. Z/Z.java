import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, cnt, answer;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        cnt = 0;
        answer = -1;

        dfs(0, 0, size);
        System.out.println(answer);
    }

    static void dfs(int startRow, int startCol, int size) {
        if (size == 1) {
            if (startRow == r && startCol == c) {
                answer = cnt;
            }
            cnt++;
            return;
        }

        int half = size / 2;
        // 사분면 순서: 1 -> 2 -> 3 -> 4
        // 사분면별로 탐색
        // 1사분면
        if (r < startRow + half && c < startCol + half) {
            dfs(startRow, startCol, half);
        }
        // 2사분면
        else if (r < startRow + half && c >= startCol + half) {
            cnt += half * half;
            dfs(startRow, startCol + half, half);
        }
        // 3사분면
        else if (r >= startRow + half && c < startCol + half) {
            cnt += 2 * half * half;
            dfs(startRow + half, startCol, half);
        }
        // 4사분면
        else {
            cnt += 3 * half * half;
            dfs(startRow + half, startCol + half, half);
        }
    }
}