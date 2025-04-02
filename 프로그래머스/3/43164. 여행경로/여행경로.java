import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> result;
    static int cnt = 0;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);
        //System.out.println(result);
        String[] answer = result.get(0).split(" ");
        return answer;
    }
    
    public static void dfs(int cnt, String start, String route, String[][] tickets) {
        if (cnt == tickets.length) {
            result.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        
        return;
    }
}