import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num = 1;

        for (int i = 0; i < N; i++) {
            sb.append(num).append(". ").append(br.readLine()).append("\n");
            num++;
        }
        System.out.println(sb);
    }
}