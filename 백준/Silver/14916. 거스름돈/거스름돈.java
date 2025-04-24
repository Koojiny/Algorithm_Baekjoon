import java.io.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n >= 0) {
            if (n % 5 == 0) {
                cnt += n / 5;
                System.out.println(cnt);
                return;
            }
            n -= 2;
            cnt++;
        }

        System.out.println(-1);
    }
}