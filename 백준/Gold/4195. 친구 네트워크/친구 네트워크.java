import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> map;
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            init(2 * F + 5);
            int idx = 0;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                if (!map.containsKey(f1)) {
                    map.put(f1, idx);
                    size[idx] = 1;
                    idx++;
                }

                if (!map.containsKey(f2)) {
                    map.put(f2, idx);
                    size[idx] = 1;
                    idx++;
                }

                int idx1 = map.get(f1);
                int idx2 = map.get(f2);

                int result = union(idx1, idx2);
                System.out.println(result);
            }
        }
    }

    static void init(int x) {
        parent = new int[x];
        size = new int[x];
        for (int i = 0; i < x; i++) {
            parent[i] = i;
            size[i] = 0;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            size[rootB] = 0;
            return size[rootA];
        }
        return size[rootA];
    }
}
