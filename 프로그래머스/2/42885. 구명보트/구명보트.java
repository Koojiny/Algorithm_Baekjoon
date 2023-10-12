import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. 배열 오름차순 정렬
        Arrays.sort(people);
        
        // 2. 양끝에서 하나씩 탐색하자 무게 제한보다 크다면 맨 오른쪽은 왼쪽으로 한칸씩 이동
        int lIdx = 0;
        int rIdx = people.length - 1;
        int answer = 0;
        
        while (lIdx <= rIdx) {
            if (people[lIdx] + people[rIdx] > limit) { // 둘의 합이 무게 제한을 넘어간다면
                answer++; // 보트 +1
                rIdx--; // 왼쪽으로 한칸 이동
                
            } else { // 둘의 합이 무게 제한을 넘지 않는다면
                answer++; // 보트 +1
                lIdx++;
                rIdx--;
            }
        }
        
        return answer;
    }
}