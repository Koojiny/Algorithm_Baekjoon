import java.io.*;
import java.util.*;

public class Main {

    static int N, K, cnt;
    static Integer[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= K) {
                cnt += K / arr[i];
                K %= arr[i];
            }
        }

        System.out.println(cnt);
    }
}