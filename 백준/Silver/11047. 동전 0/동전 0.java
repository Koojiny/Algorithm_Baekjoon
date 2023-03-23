import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, cnt;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (x, y) -> y-x); // 내림차순 정렬
//        System.out.println(Arrays.toString(arr));

        cnt = 0; // 동전 개수 최솟값

        for (int i = 0; i < N; i++) {
            if (arr[i] <= K) {
                cnt += K / arr[i];
                K = K % arr[i];
            }
        }

        System.out.println(cnt);
    }
}