import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 정수 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = arr[0];
            int min = arr[0];

            for (int j = 1; j < N; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
            }
            sb.append(min).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }
}