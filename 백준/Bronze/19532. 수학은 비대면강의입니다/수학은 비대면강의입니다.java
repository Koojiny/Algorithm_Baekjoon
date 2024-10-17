import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                int one = a * i + b * j;
                int two = d * i + e * j;
                if (one == c && two == f) {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}