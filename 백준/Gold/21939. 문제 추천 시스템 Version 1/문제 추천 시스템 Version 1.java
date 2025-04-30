import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> low = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<int[]> high = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        // 문제 번호 -> 레벨
        Map<Integer, Integer> problems = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            problems.put(p, l);
            low.offer(new int[]{p, l});
            high.offer(new int[]{p, l});
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                problems.put(p, l);
                low.offer(new int[]{p, l});
                high.offer(new int[]{p, l});
            } else if (cmd.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                problems.remove(p); // 제거만 하면 됨
            } else if (cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    while (!high.isEmpty() && problems.getOrDefault(high.peek()[0], -1) != high.peek()[1]) {
                        high.poll();
                    }
                    System.out.println(high.peek()[0]);
                } else {
                    while (!low.isEmpty() && problems.getOrDefault(low.peek()[0], -1) != low.peek()[1]) {
                        low.poll();
                    }
                    System.out.println(low.peek()[0]);
                }
            }
        }
    }
}
