import java.util.*;

class Solution {
     public static String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. Hash map을 만든다 (participant)
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            // player의 값을 가져왔을 때 없다면 0 + 1로 설정
            // 있다면 해당하는 값을 가져오고 + 1로 설정 (동명이인이 있을 수 있기 때문)
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 2. HASH map을 뺀다 (completion)
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        // 3. value 가 0이 아닌 마지막 주자를 찾는다
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}