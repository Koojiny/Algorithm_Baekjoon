import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;
        Map<String, Integer> targetMap = new HashMap<String, Integer>();
        
        for (int i = 0; i < want.length; i++) {
            targetMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            int idx = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();
            
            for (int j = 0; j < 10; j++) {
                map.put(discount[i + j], map.getOrDefault(discount[i + j], 0) + 1);
            }
            
            for (Map.Entry<String, Integer> entry : targetMap.entrySet()) {
                if (map.containsKey(entry.getKey()) && entry.getValue() <= map.get(entry.getKey())) idx++;
            }
                
            if (idx == want.length) cnt++;
        }
        
        return cnt;
    }
}