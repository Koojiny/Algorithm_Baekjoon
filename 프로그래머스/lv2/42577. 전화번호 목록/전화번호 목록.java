import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        // 1. 해쉬맵에 값을 담는다(전화번호부 저장)
        HashMap<String, Integer> map = new HashMap<>();
        for (String num : phone_book) {
            map.put(num, 1);
        }

        // 2. 맵 순회하면서 접두어인 경우 확인
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        // 3. 여기까지 다 통과한 경우는 접두어 없는 경우
        return true;
    }
}