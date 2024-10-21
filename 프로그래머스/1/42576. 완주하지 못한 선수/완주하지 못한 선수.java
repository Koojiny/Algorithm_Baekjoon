import java.util.*;

class Solution {
    
    public static HashMap<String, Integer> map = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        for (String success : completion) {
            map.put(success, map.get(success) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}