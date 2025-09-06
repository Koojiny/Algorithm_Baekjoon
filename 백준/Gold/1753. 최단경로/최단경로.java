import java.io.*;
import java.util.*;

public class Main {
    public static int V, E, K;
    public static List<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수
        K = Integer.parseInt(br.readLine()); // 시작점

        // 방향그래프 설정
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작
            int v = Integer.parseInt(st.nextToken()); // 끝
            int w = Integer.parseInt(st.nextToken()); // 가중치

            graph[u].add(new Node(v, w));
        }

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.v]) {
                visited[cur.v] = true;

                for (Node next : graph[cur.v]) {
                    if (!visited[next.v] && dist[next.v] > dist[cur.v] + next.w) {
                        dist[next.v] = dist[cur.v] + next.w;
                        pq.offer(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (i == K) System.out.println(0);
            else {
                if (dist[i] != Integer.MAX_VALUE) System.out.println(dist[i]);
                else System.out.println("INF");
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return this.w - other.w;
        }
    }
}

