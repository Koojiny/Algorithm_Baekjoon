import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지역 개수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        // 각 지역의 아이템 개수 저장
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 거리 정보 저장 (플로이드-워셜)
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작
            int b = Integer.parseInt(st.nextToken()); // 도착
            int l = Integer.parseInt(st.nextToken()); // 길이

            dist[a][b] = Math.min(dist[a][b], l);
            dist[b][a] = Math.min(dist[b][a], l);
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (dist[s][k] != INF && dist[k][e] != INF)
                        dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
                }
            }
        }

        int maxItem = 0;
        for (int s = 1; s <= n; s++) {
            int sum = 0;
            for (int e = 1; e <= n; e++) {
                // 현재 경로의 범위가 m이하인 경우 합산
                if (dist[s][e] <= m) sum += items[e];
            }
            maxItem = Math.max(maxItem, sum);
        }

        System.out.println(maxItem);
    }
}

