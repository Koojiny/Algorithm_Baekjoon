import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int size = 100000;

        int[] dist = new int[size + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(n);
        dist[n] = 0;

        while (!dq.isEmpty()) {
            int now = dq.pollFirst();

            if (now == k) {
                System.out.println(dist[now]);
                return;
            }

            // 비용 0
            int next = now * 2;
            if (next <= size && dist[next] == -1) {
                dist[next] = dist[now]; // 시간 증가 없음
                dq.addFirst(next);      // 0초는 앞쪽으로 넣기
            }

            // 비용 1
            next = now - 1;
            if (next >= 0 && dist[next] == -1) {
                dist[next] = dist[now] + 1; // 1초 증가
                dq.addLast(next);           // 1초는 뒤쪽으로 넣기
            }

            next = now + 1;
            if (next <= size && dist[next] == -1) {
                dist[next] = dist[now] + 1; // 1초 증가
                dq.addLast(next);           // 1초는 뒤쪽으로 넣기
            }
        }
    }
}