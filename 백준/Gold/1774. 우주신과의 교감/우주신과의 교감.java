import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 우주신들의 개수
        M = Integer.parseInt(st.nextToken()); // 통로의 개수

        // 각 좌표의 정보 저장
        SpaceGod[] gods = new SpaceGod[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            gods[i] = new SpaceGod(X, Y);
        }

        // 각 좌표별 거리를 저장
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int aX = gods[i].x;
                int aY = gods[i].y;
                int bX = gods[j].x;
                int bY = gods[j].y;
                double d1 = aX - bX;
                double d2 = aY - bY;
                double curD = Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));

                edgeList.add(new Edge(i, j, curD));
            }
        }

        Collections.sort(edgeList);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        double totalDist = 0.0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (Edge edge : edgeList) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                totalDist += edge.dist;
            }
        }

        System.out.printf("%.2f", totalDist);
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int rA = find(a);
        int rB = find(b);
        if (rA != rB) {
            parent[rB] = rA;
        }
    }

    static class SpaceGod {
        int x;
        int y;

        public SpaceGod(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        double dist;

        public Edge(int u, int v, double dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.dist < o.dist) return -1;
            else if (this.dist == o.dist) return 0;
            else return 1;
        }
    }
}
