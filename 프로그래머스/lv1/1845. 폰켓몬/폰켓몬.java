import java.util.*;

class Solution {
    public static int solution(int[] nums) {
        // 1. 해쉬 생성해서 값 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 2. 종류를 세자 (key 개수를 세면 됨)
        int answer = 0;
        for (int key : map.keySet()) {
            answer++;
        }

        // 3. 예외조건 처리하자 (총 포켓몬 중 N/2 마리만 가능하다)
        if (answer > nums.length / 2) answer = nums.length / 2;
        return answer;
    }
}