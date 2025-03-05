import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 1. 스킬트리 배열 순회
        for (String s : skill_trees) {
            // 2. 스킬트리 하나를 꺼낸 후 각 문자열을 선행스킬과 비교하여 스킬트리 한 개를 필터링
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                if (skill.contains(s.charAt(i) + "")) { // 선행스킬 내에 없는 스킬인 경우 sb에 추가
                    sb.append(s.charAt(i));
                }
            }
            // 3. 최종적으로 필터링 된 스킬트리를 다시 순회하면서 선행스킬에 포함된 문자열인지 확인 후 Count + 1
            if (skill.startsWith(sb.toString())) answer++;
        }
       
        return answer;
    }
}