import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, X;
    public static List<Node>[] graph;
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마을 수
        M = Integer.parseInt(st.nextToken()); // 단방향 도로 개수
        X = Integer.parseInt(st.nextToken()); // 파티 열리는 마을

        // 방향그래프 설정
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, dist));
        }

        for (int i = 1; i <= N; i++) {
            int startDist = dijkstra(i, X);
            int returnDist = dijkstra(X, i);

            answer = Math.max(answer, startDist + returnDist);
        }

        System.out.println(answer);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.edge]) continue;
            visited[cur.edge] = true;

            for (Node next : graph[cur.edge]) {
                if (!visited[next.edge] && dist[next.edge] > dist[cur.edge] + next.dist) {
                    dist[next.edge] = dist[cur.edge] + next.dist;
                    pq.offer(new Node(next.edge, dist[next.edge]));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int edge;
        int dist;

        public Node(int edge, int dist) {
            this.edge = edge;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return this.dist - other.dist;
        }
    }
}
