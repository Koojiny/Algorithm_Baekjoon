import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int res = 1;
        for (int i = N; i > 0; i--) {
            res *= i;
        }
        System.out.println(res);
    }
}