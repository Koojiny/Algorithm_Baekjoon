import java.io.*;
import java.util.*;

public class Main {
    public static int N, Q;
    public static List<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) { // N - 1 개의 정보
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new int[]{q, r});
            graph[q].add(new int[]{p, r});
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N + 1];
            visited[v] = true;

            Queue<Integer> q = new LinkedList<>();
            q.add(v);

            int answer = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int[] a : graph[cur]) {
                    if (!visited[a[0]] && a[1] >= k) {
                        q.add(a[0]);
                        visited[a[0]] = true;
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
