import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            if (q.size() < cacheSize){ // 큐가 다 차지 않은 경우
                if (q.contains(city)) { // 해당 도시 있는 경우
                    q.remove(city);
                    q.offer(city);
                    answer++;
                } else { // 해당 도시 없는 경우
                    q.offer(city);
                    answer += 5;
                }
            } else { // 큐가 다 차있는 경우
                if (q.contains(city)) { // 해당 도시 있는 경우
                    q.remove(city);
                    q.offer(city);
                    answer++;
                } else { // 해당 도시 없는 경우
                    q.poll();
                    q.offer(city);
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}