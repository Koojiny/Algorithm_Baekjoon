import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<City>[] bus = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            bus[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int startN = Integer.parseInt(st.nextToken());
            int endN = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            bus[startN].add(new City(endN, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));

        while (!pq.isEmpty()) {
            City c = pq.poll(); // end = 1 cost = 0

            if (!visited[c.end]) {
                visited[c.end] = true;

                for (City next : bus[c.end]) {
                    if (!visited[next.end] && dist[next.end] > dist[c.end] + next.cost) {
                        dist[next.end] = dist[c.end] + next.cost;
                        pq.add(new City(next.end, dist[next.end]));
                    }
                }
            }
        }

        System.out.println(dist[end]);
    }
}

class City implements Comparable<City> {
    int end;
    int cost;

    public City(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(City other) {
        return this.cost - other.cost;
    }
}