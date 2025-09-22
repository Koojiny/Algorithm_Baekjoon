import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] bulbs, target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bulbs = new int[N];
        target = new int[N];

        String b = br.readLine();
        for (int i = 0; i < N; i++) {
            bulbs[i] = Integer.parseInt(b.substring(i, i + 1));
        }

        String r = br.readLine();
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(r.substring(i, i + 1));
        }

        // case1 첫 전구를 누르는 경우, case2 안 누르는 경우
        int case1 = simulate(bulbs.clone(), false);
        int case2 = simulate(bulbs.clone(), true);

        int ans = -1;
        // 둘 다 가능
        if (case1 >= 0 && case2 >= 0) ans = Math.min(case1, case2);
        else if (case1 >= 0) ans = case1;
        else if (case2 >= 0) ans = case2;

        System.out.println(ans);
    }

    static int simulate(int[] arr, boolean pressFirst) {
        int cnt = 0;
        if (pressFirst) {
            press(arr, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != target[i - 1]) {
                press(arr, i);
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] != target[i]) return -1;
        }

        return cnt;
    }

    static void press(int[] arr, int idx) {
        arr[idx] = 1 - arr[idx];
        if (idx - 1 >= 0) arr[idx - 1] = 1 - arr[idx - 1];
        if (idx + 1 < N) arr[idx + 1] = 1 - arr[idx + 1];
    }
}
