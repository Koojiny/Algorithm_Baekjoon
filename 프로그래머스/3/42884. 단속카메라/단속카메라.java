import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 두 번째 값 기준 오름차순, 같으면 첫 번째 값 기준 오름차순
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            }
        });
        
        int std = routes[0][1];
        int answer = 1;
        for (int i = 1; i < routes.length; i++) {
            // System.out.println(Arrays.toString(pair));
            if (routes[i][0] <= std) continue;
            else {
                answer++;
                std = routes[i][1];
            }
        }
        
        return answer;
    }
}