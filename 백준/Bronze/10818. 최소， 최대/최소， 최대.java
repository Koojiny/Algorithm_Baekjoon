import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < N; i++) {
            if (max < arr[i]) max = arr[i];
        }
        for (int i = 1; i < N; i++) {
            if (min > arr[i]) min = arr[i];
        }
        System.out.println(min + " " + max);
    }
}