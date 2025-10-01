import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD의 수

        int[] indegree = new int[N + 1]; // 진입 차수 저장

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];

            for (int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < num; j++) {
                int a = arr[j - 1];
                int b = arr[j];

                graph.get(a).add(b);
                indegree[b]++;
            }
        }

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // 순서 저장 리스트
        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (result.size() < N) {
            System.out.println(0);
        } else{
            for (int i = 0; i < N; i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
