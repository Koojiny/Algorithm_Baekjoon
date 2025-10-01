import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 건물 개수
            int K = Integer.parseInt(st.nextToken());   // 건설순서 규칙 총 개수

            int[] times = new int[N + 1];       // 건설에 걸리는 시간 배열
            int[] indegree = new int[N + 1];    // 진입 차수 저장 배열
            int[] dp = new int[N + 1];          // dp[x]: 건물 x가 완성되기까지의 최소 시간

            // 건설 시간 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }

            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            // 건설 순서 규칙
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                indegree[y]++;
            }

            // 목표 건물 번호
            int W = Integer.parseInt(br.readLine());

            // 건설 완료 최소 시간
            int totalTime = 0;

            // 시작점부터 넣고 시작
            Queue<Integer> q = new LinkedList<>();
            for (int j = 1; j <= N; j++) {
                if (indegree[j] == 0) {
                    q.add(j);
                    dp[j] = times[j];
                }
            }

            // 위상 정렬 시작
            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : graph.get(now)) {
                    // 모든 선행 건물의 완료 시간 중 최댓값 + 자신의 건설 시간
                    dp[next] = Math.max(dp[next], dp[now] + times[next]);
                    // now에 대한 처리를 완료했으므로 1 감소
                    indegree[next]--;
                    if (indegree[next] == 0) q.add(next);
                }
            }

            // 최종 시간 출력
            System.out.println(dp[W]);
        }
    }
}
