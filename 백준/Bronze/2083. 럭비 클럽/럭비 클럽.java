import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("# 0 0")) break;

            st = new StringTokenizer(line);
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (age > 17 || weight >= 80) {
                sb.append(name).append(' ').append("Senior").append('\n');
            } else {
                sb.append(name).append(' ').append("Junior").append('\n');
            }
        }
        System.out.println(sb);
    }
}