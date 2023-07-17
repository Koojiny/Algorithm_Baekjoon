import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // test case

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A의 수
            int M = Integer.parseInt(st.nextToken()); // B의 수
            int[] arrA = new int[N];
            int[] arrB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // A 배열에 넣기
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) { // B 배열에 넣기
                arrB[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);
            int result = 0;

            for (int l = 0; l < arrA.length; l++) {
                for (int m = 0; m < arrB.length; m++) {
                    if (arrA[l] <= arrB[m]) {
                        break;
                    } else {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
