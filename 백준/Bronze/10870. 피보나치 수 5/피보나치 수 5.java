import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(Fivonacci(n));
    }

    public static int Fivonacci(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        return Fivonacci(x - 1) + Fivonacci(x - 2);
    }
}