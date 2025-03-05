import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 컨테이너 벨트는 놓인 순서대로만 내릴 수 있다
        // 보조 컨테이너 벨트는 맨 앞 상자만 뺄 수 있다 = 스택
        // 컨테이너 벨트 [1 2 3 4 5]
        // 보조 컨테이너 [ 1 2 3(제거)
        // 트럭 [4 3]
        
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트
        int n = order.length; // 상자 개수
        int answer = 0;
        int idx = 0;
        
        for (int i = 1; i <= n; i++) { // 1부터 상자 개수만큼 반복
            if (i == order[idx]) { // 현재 상자번호와 순서의 숫자가 같으면 바로 트럭으로 이동
                answer++;
                idx++;
            } else { // 다르면 보조 컨테이너(스택)에 넣기
                stack.push(i);
            }
            
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
            }
        }
                
        return answer;
    }
}