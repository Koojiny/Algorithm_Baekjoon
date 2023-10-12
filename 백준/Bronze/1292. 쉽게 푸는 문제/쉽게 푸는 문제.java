import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0; // 몇 번째인지 체크
        int sum = 0; // 범위 안에 들어가면 누적합을 구함

        for (int i = 1; i <= B; i++) {
            for (int j = 0; j < i; j++) {
                cnt++;

                if (cnt >= A && cnt <= B) sum += i;
            }
        }
        System.out.println(sum);
    }
}