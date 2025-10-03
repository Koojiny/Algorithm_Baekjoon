import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        // 플로이드-워셜 거리 배열
        int[][] dist = new int[n + 1][n + 1];

        // 1. 배열 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // 2. 버스 정보 저장 (거리 정보 저장)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용

            dist[a][b] = Math.min(c, dist[a][b]);
        }

        // 3. 플로이드-워셜 알고리즘 진행
        for (int k = 1; k <= n; k++) {          // 중간 지점
            for (int s = 1; s <= n; s++) {      // 시작 지점
                for (int e = 1; e <= n; e++) {  // 도착 지점
                    if (dist[s][k] != INF && dist[k][e] != INF)
                    dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
                }
            }
        }

        // 4. 정답 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (dist[i][j] == 0 || dist[i][j] == INF)? 0 : dist[i][j];
                System.out.print(cost + " ");
            }
            System.out.println();
        }
    }
}
