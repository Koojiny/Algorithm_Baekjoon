import java.util.*;

class Solution {
    static HashSet<Integer> numberSet = new HashSet<>();

    public static int solution(String numbers) {
        int count = 0;
        // 1. 모든 조합의 숫자를 만든다
        recursive("", numbers);

        // 2. 소수의 개수만 센다
        Iterator<Integer> it = numberSet.iterator();

        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) count++;
        }

        // 3. 소수의 개수를 반환한다
        return count;
    }

    public static void recursive(String combination, String others) {
        // 1. 현재 조합을 set에 추가한다
        if (!combination.equals("")) { // combination이 빈 값만 아니면 set에 넣어라
            numberSet.add(Integer.parseInt(combination));
        }

        // 2. 남은 숫자 중 한개를 더해 새로운 조합을 만든다
        for (int i = 0; i < others.length(); i++) {
            recursive(combination + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}