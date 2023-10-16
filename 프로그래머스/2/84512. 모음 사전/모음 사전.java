import java.util.*;

class Solution {
    static String[] arr;
    static List<String> list;
    
    public int solution(String word) {
        
        arr = new String[]{"A", "E", "I", "O", "U"};
        list = new ArrayList<>();
        
        // 재귀함수 호출
        recursion("", 0);
        
        Iterator<String> it = list.iterator();
        int count = 0;
        
        while (it.hasNext()) {
            String cur = it.next();
            if (cur.equals(word)) break;
            count++;
        }
        
        // 몇 번째인지 순서 반환
        return count;
    }
    
    static void recursion(String str, int depth) {
        list.add(str);
        
        // 종료조건: 재귀함수 내에서 깊이 5가 되면 return
        if (depth == 5) return;
        
        // 수행동작: 재귀함수로 단어를 모두 생성
        for (int i = 0; i < arr.length; i++) {
            recursion(str + arr[i], depth + 1);
        }
    }
}