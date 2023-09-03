import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int idx = 0;

        for (int i = 0; i < 9; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val > max) {
                max = val;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx + 1);
    }
}