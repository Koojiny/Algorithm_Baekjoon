import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("0 0 0")) break;
            StringTokenizer st = new StringTokenizer(line);

            long[] arr = new long[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(arr);

            if ((arr[0] * arr[0] + arr[1] * arr[1]) == arr[2] * arr[2]) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}