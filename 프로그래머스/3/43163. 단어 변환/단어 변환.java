import java.util.*;

class Solution {
    
    public static ArrayList<String> list = new ArrayList<>();
    public static boolean[] visit; // 방문 체크 배열
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 배열 안의 단어를 모두 리스트에 넣기
        for (String word : words) {
            list.add(word);
        }
        
        // 리스트 안에 타겟 단어가 없다면 0 반환
        if(!list.contains(target)) return 0;
        
        visit = new boolean[words.length];
        
        // DFS
        answer = dfs(begin, target, 0);
                
        return answer;
    }
    
    public static int dfs(String word, String target, int depth) {
        // 목표 단어 도달 시 깊이 반환
        if (word.equals(target)) return depth;
        
        int minDepth = Integer.MAX_VALUE;
        
        for (int i = 0; i < list.size(); i++) {
            if (!visit[i] && isOneLetterDiff(word, list.get(i))) {
                visit[i] = true;
                minDepth = Math.min(minDepth, dfs(list.get(i), target, depth + 1));
                visit[i] = false;
            }
        }
        
        return minDepth;
    }
    
    public static boolean isOneLetterDiff(String word1, String word2) {
        int diffCount = 0;
        
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diffCount++;
        }
        
        return diffCount == 1;
    }
}