import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{a, 0});

        while (!q.isEmpty()) {
            long[] temp = q.poll();
            long now = temp[0];
            long cnt = temp[1];

            if (now == b) {
                System.out.println(cnt + 1);
                return;
            }

            if (now * 2 <= b) {
                q.offer(new long[]{now * 2, cnt + 1});
            }
            if (now * 10 + 1 <= b) {
                q.offer(new long[]{now * 10 + 1, cnt + 1});
            }
        }

        System.out.println(-1);
    }
}