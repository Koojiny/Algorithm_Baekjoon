import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        
        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];
            dist[x][y] = cost;
            dist[y][x] = cost;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int st = 1; st <= n; st++) {
                for (int en = 1; en <= n; en++) {
                    if (dist[st][k] != INF && dist[k][en] != INF) {
                        dist[st][en] = Math.min(dist[st][en], dist[st][k] + dist[k][en]);
                    }
                }
            }
        }
        
        int answer = INF;
        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        
        return answer;
    }
}