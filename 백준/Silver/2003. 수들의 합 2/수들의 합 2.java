import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
//        System.out.println(Arrays.toString(arr));
        int cnt = 0;
        int startIdx = 0;
        int endIdx = 0;
        int len = arr.length;
        int sum = 0;

        while (true) {
            if (sum >= M) {
                sum -= arr[startIdx++];
            } else if (endIdx >= N) {
                break;
            } else {
                sum += arr[endIdx++];
            }
            if (sum == M) cnt++;
        }
       
        System.out.println(cnt);
    }
}
