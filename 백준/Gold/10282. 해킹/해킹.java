import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<Node>[] graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 1; j <= d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Node(a, s));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(c, 0));

            boolean[] visited = new boolean[n + 1];
            int[] time = new int[n + 1];
            Arrays.fill(time, INF);
            time[c] = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (visited[cur.computer]) continue;
                visited[cur.computer] = true;

                for (Node next : graph[cur.computer]) {
                    if (!visited[next.computer] && time[next.computer] > time[cur.computer] + next.time) {
                        time[next.computer] = time[cur.computer] + next.time;
                        pq.offer(new Node(next.computer, time[next.computer]));
                    }
                }
            }

            int infectCom = 0;
            int lastTime = 0;

            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    infectCom++;
                    lastTime = Math.max(lastTime, time[j]);
                }
            }
            System.out.println(infectCom + " " + lastTime);
        }
    }

    static class Node implements Comparable<Node> {
        int computer;
        int time;

        public Node(int computer, int time) {
            this.computer = computer;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return this.time - other.time;
        }
    }
}
