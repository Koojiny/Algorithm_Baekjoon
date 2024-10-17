import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
                
        q.offer(new int[]{0, 0, 1});
        visit[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];
            
            if (y == n - 1 && x == m - 1) return dist; // 목표지점 도달 시
                        
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                
                if (0 <= nx && nx < m && 0 <= ny && ny < n && maps[ny][nx] == 1 && !visit[ny][nx]) {
                    q.offer(new int[]{ny, nx, dist + 1});
                    visit[ny][nx] = true;
                }
            }
        }
        
        return -1;
    }
}