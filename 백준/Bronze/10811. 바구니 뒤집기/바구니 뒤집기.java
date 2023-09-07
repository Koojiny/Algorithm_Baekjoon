import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());

            for (int j = I; j <= (I + J) / 2; j++) {
                int tmp = arr[j];
                arr[j] = arr[I + J - j];
                arr[I + J - j] = tmp;
            }
        }

        for (int i = 1; i <= N ; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}