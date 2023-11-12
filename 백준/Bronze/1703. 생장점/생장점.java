import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int branch = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            if (age == 0) break;

            for (int i = 0; i < age; i++) {
                branch *= Integer.parseInt(st.nextToken());
                branch -= Integer.parseInt(st.nextToken());
            }
            System.out.println(branch);
            branch = 1;
        }
    }
}