import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] chess = {1, 1, 2, 2, 2, 8};

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i : chess) {
            sb.append(i - Integer.parseInt(st.nextToken())).append(' ');
        }
        System.out.println(sb);
    }
}