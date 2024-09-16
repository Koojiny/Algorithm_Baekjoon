import java.util.*;

class Solution {
    public static HashSet<Integer> numberSet = new HashSet<>(); // 숫자 조합 넣을 해시셋 선언;
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 1. 모든 조합의 숫자를 생성
        makeNumber("", numbers);
        
        System.out.println(numberSet);
        // 2. 소수 판별
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) answer++;
        }
            
        // 3. 소수 개수 리턴
        return answer;
    }
    
    public void makeNumber(String comb, String others) {
        // 1. 현재 조합을 set에 추가
        if (!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));
        
        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다
        for (int i = 0; i < others.length(); i++) {
            makeNumber(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}