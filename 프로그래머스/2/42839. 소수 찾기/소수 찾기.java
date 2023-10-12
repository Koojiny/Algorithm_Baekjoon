import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 1. 모든 숫자의 조합을 만든다
        combination("", numbers);
        
        // 2. 소수인지 판별한다
        Iterator<Integer> it = set.iterator();
        
        while(it.hasNext()) {
            int num = it.next();
            if (isPrime(num)) answer++;
        }
        
        // 3. 소수 개수 반환
        return answer;
    }
    
    public static void combination(String comb, String forUse) {
        if (!comb.equals("")) { // 빈 문자열이 아니라면 값을 Set에 넣어라
            set.add(Integer.parseInt(comb));
        }
        
        for (int i = 0; i < forUse.length(); i++) {
            combination(comb + forUse.charAt(i), forUse.substring(0, i) + forUse.substring(i + 1));
        }
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}