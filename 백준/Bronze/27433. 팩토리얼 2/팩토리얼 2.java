import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        System.out.println(Factorial(N));
    }
    public static long Factorial(long x) {
        if (x == 0 || x == 1) {
            return 1;
        }

        return x * Factorial(x - 1);
    }
}