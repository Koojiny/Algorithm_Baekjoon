import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 연결선의 수

        List<Computer> computers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            computers.add(new Computer(a, b, c));
        }

        // 비용 오름차순 정렬
        Collections.sort(computers);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 최소비용
        int totalCost = 0;
        for (Computer c : computers) {
            if (find(c.start) != find(c.end)) { // 두 컴퓨터가 같은 그룹이 아니면
                // 그룹을 합치고, 비용 합산
                union(c.start, c.end);
                totalCost += c.cost;
            }
        }

        System.out.println(totalCost);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rA = find(a);
        int rB = find(b);

        if (rA != rB) {
            parent[rB] = rA;
        }
    }

    static class Computer implements Comparable<Computer> {
        int start;
        int end;
        int cost;

        public Computer(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Computer other) {
            return this.cost - other.cost;
        }
    }
}
