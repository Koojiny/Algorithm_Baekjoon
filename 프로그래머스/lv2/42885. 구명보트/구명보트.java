import java.util.*;

class Solution {
      public static int solution(int[] people, int limit) {
        // 양 사이드의 가장 작은 값과 가장 큰 값을 더하기 위해
        // 배열 오름차순으로 정렬
        Arrays.sort(people);

        int cnt = 0;

        // index로 접근하기 위해 왼쪽 오른쪽 변수 선언
        int left = 0;
        int right = people.length - 1;

        // left와 right이 만날 때까지 반복
        while (left <= right) { // left가 right보다 작거나 같을 때까지
            if (people[left] + people[right] <= limit) {
                left++; // 몸무게 낮은 사람이 탐
            }
            // 반대의 경우 큰 사람은 항상 보트에 타게 되기 때문에 오른쪽을 이동
            right--;
            // 둘 중 하나가 이동할 때마다 보트 갯수는 증가
            cnt++;
        }

        return cnt;
    }
}