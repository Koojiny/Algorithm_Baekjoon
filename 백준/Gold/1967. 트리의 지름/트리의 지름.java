import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static List<Node>[] tree;
    public static boolean[] visited;
    public static int maxLength;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        maxLength = 0;
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }

        System.out.println(maxLength);
    }

    public static void dfs(int start, int dist) {
        maxLength = Math.max(maxLength, dist);

        for (Node next : tree[start]) {
            if (visited[next.child]) continue;
            visited[next.child] = true;
            dfs(next.child, dist + next.weight);
            visited[next.child] = false;
        }
    }

    static class Node {
        int child;
        int weight;

        public Node(int child, int weight) {
            this.child = child;
            this.weight = weight;
        }
    }
}
