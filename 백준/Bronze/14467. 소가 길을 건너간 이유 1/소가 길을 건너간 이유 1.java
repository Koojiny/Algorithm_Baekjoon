import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cow_list = new int[11];
        Arrays.fill(cow_list, -1);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int leftright = Integer.parseInt(st.nextToken());

            if (cow_list[cow] != -1 && cow_list[cow] != leftright) cnt++;
            cow_list[cow] = leftright;
        }
        System.out.println(cnt);
    }
}