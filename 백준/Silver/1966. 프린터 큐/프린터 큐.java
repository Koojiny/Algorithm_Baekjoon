import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;

            while (!queue.isEmpty()) {
                int [] front = queue.poll(); // 가장 첫 원소
                boolean isMax = true; // front 원소가 가장 큰 원소인지를 판단

                for (int q[] : queue) {
                    if (front[1] < q[1]) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    cnt++;
                    if (front[0] == M) break;
                } else {
                    queue.offer(front);
                }

            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}