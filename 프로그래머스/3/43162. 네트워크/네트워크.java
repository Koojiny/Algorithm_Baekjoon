class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int node, int[][] computers, boolean[] visited, int n) {
        visited[node] = true;
        
        for (int i = 0; i < n; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited, n);
            }
        }
    }
}