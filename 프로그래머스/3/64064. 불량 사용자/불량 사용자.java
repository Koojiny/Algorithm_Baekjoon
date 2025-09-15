import java.util.*;

class Solution {
    public static boolean[] visited;
    public static Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        dfs(new HashSet<>(), 0, user_id, banned_id);
        
        return result.size();
    }
    
    public static void dfs(Set<String> current, int depth, String[] user_id, String[] banned_id) {
        // 모든 banned_id에 대해 user 할당했으면 탈출
        if (depth == banned_id.length) {
            result.add(new HashSet<>(current)); // 현재 조합 결과에 추가
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            
            // 패턴 일치할 경우
            if (isMatch(user_id[i], banned_id[depth])) {
                // 선택
                visited[i] = true;
                current.add(user_id[i]);
                
                // 다음 banned_id로 이동
                dfs(current, depth + 1, user_id, banned_id);
                
                // 백트래킹
                current.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isMatch(String user, String banned) {
        // 길이 다른 경우, 매칭 불가
        if (user.length() != banned.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            char u = user.charAt(i);
            char b = banned.charAt(i);
            
            // * 이면 패스, 아니면 문자 일치해야 함
            if (b == '*') continue;
            if (u != b) return false;
        }
        
        // 끝까지 통과했으면 true
        return true;
    }
}