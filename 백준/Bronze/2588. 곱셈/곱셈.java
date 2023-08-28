import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        int[] arr = new int[b.length()];

        for (int i = 0; i < 3; i++) {
            arr[i] = b.charAt(i) - '0';
        }

        System.out.println(a * arr[2]);
        System.out.println(a * arr[1]);
        System.out.println(a * arr[0]);
        System.out.println(a * arr[0] * 100 + a * arr[1] * 10 + a * arr[2]);
    }
}