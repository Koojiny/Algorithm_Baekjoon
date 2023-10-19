import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 정렬을 진행
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // System.out.println(Arrays.deepToString(routes));
        
        int answer = 0;
        int curEnd = Integer.MIN_VALUE;
        
        for (int i = 0; i < routes.length; i++) {
            
            if (routes[i][0] > curEnd) {
                curEnd = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}