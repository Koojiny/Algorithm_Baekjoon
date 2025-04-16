import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long gcd = Long.parseLong(st.nextToken());
        long lcm = Long.parseLong(st.nextToken());
        long ans1 = gcd;
        long ans2 = lcm;

        long xy = gcd * lcm;

        for (long i = 2 * gcd; i * i <= xy; i += gcd) {
            if (xy % i == 0) {
                long temp = xy / i; // 540

                if (gcd(i, temp) == gcd) {
                    if(ans1 + ans2 > i + temp) {
                        ans1 = i;
                        ans2 = temp;
                    }
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    public static long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}