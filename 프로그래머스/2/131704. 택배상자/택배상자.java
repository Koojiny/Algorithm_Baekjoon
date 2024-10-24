import java.util.*;

class Solution {
    
    public static Queue<Integer> queue = new LinkedList<>(); // 컨베이어 벨트
    public static Stack<Integer> stack = new Stack<>(); // 보조 컨베이어 벨트
    
    public int solution(int[] order) {
        int answer = 0;
        
        for (int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }
        
        // 택배 상자 1~n까지 번호 증가하는 순서로 정렬하여 큐에 넣기
        // 1부터 확인하면서 order과 비교 후 같다면 order 인덱스 + 1, 큐에서 제거 다르면 스택에 넣기
        
        int idx = 0;
        while(true) {
            if (queue.isEmpty() && (stack.isEmpty() || stack.peek() != order[idx])) {
                break;
            }
            
            int curQueue = 0;
            if (!queue.isEmpty()) {
                queue.peek(); // 컨베이어벨트의 제일 앞의 값    
            }
            
            int curStack = 0;
            if (stack.size() > 0) {
                curStack = stack.peek(); // 보조컨베이어벨트의 제일 위의 값    
            }
                        
            if (order[idx] == curQueue) { // 현재값과 현재 필요한 택배상자 번호와 일치한다면 제거
                queue.poll();
                idx++;
                answer++;
            } else if (order[idx] == curStack) {
                stack.pop();
                idx++;
                answer++;
            } else {
                if (!queue.isEmpty()) {
                    stack.push(queue.poll());   
                }
            }
        }

        return answer;
    }
}