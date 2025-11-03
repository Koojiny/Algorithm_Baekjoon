import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        while (true) {
            // 모두 0이 된 경우 탈출
            if (check()) break;

            // 모두 짝수인지 체크
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 != 0) {
                    flag = false;
                    arr[i]--;
                    cnt++;
                    break;
                }
            }

            // 모두 짝수인 경우 전체 2로 나누기
            if (flag) {
                for (int i = 0; i < N; i++) {
                    arr[i] /= 2;
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}
