import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        sb.append('<');
        while (queue.size() > 1) {
            cnt += 1;
            if (cnt == K) {
                cnt = 0;
                sb.append(queue.poll()).append(", ");
            } else {
                queue.offer(queue.poll());
            }
        }
        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
}