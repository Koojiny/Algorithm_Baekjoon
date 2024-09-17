import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 토핑의 전체 종류 수를 세는 Map
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        
        // 왼쪽에 있는 토핑 종류를 저장하는 Set
        Set<Integer> leftSet = new HashSet<>();
        
        // 배열을 순회하며 토핑을 왼쪽으로 이동
        for (int i = 0; i < topping.length; i++) {
            // 현재 토핑을 왼쪽으로 옮김
            leftSet.add(topping[i]);
            
            // 오른쪽 맵에서 현재 토핑의 개수를 하나 줄임
            rightMap.put(topping[i], rightMap.get(topping[i]) - 1);
            if (rightMap.get(topping[i]) == 0) {
                rightMap.remove(topping[i]);
            }
            
            // 왼쪽과 오른쪽에 있는 종류 수가 같다면 answer 증가
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
