import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학교의 수
        M = Integer.parseInt(st.nextToken()); // 연결하는 도로의 수

        // 남초/여초 구분
        String[] gender = new String[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            gender[i] = st.nextToken();
        }

        List<Edge> edgeList = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(u, v, d));
        }

        Collections.sort(edgeList);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int totalDist = 0;
        visited = new boolean[N + 1];
        for (Edge edge : edgeList) {
            // 같은 그룹이 아니고, 서로 다른 성별의 학교인 경우
            if (find(edge.u) != find(edge.v) && !gender[edge.u].equals(gender[edge.v])) {
                union(edge.u, edge.v);
                totalDist += edge.dist;
            }
        }

        if (isOk()) {
            System.out.println(totalDist);
        } else {
            System.out.println(-1);
        }
    }

    static boolean isOk() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        visited[a] = true;
        visited[b] = true;
        int rA = find(a);
        int rB = find(b);
        if (rA != rB) {
            parent[rB] = rA;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int dist;

        public Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
