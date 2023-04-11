class Solution {
    static int answer = 0;
    
    static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }
    
    static void dfs(int [] numbers, int depth, int target, int sum) {
        
        if (depth == numbers.length) {
            if (target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}