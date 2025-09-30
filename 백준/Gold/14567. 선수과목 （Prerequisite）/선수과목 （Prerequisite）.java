import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입 차수 배열
        int[] indegree = new int[N + 1];
        // 학기 기록 배열
        int[] semester = new int[N + 1];

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                semester[i] = 1;
            }
        }

        // 위상 정렬 수행
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : graph.get(now)) {
                indegree[next]--;
                semester[next] = Math.max(semester[next], semester[now]+ 1);
                
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            System.out.print(semester[i] + " ");
        }
    }
}
