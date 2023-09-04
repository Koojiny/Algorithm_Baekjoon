import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] basket = new int[Integer.parseInt(st.nextToken())];
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < basket.length; i++) {
            basket[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int tmp;
            tmp = basket[I - 1];
            basket[I - 1] = basket[J - 1];
            basket[J - 1] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < basket.length; i++) {
            sb.append(basket[i]).append(' ');
        }
        System.out.println(sb);
    }
}