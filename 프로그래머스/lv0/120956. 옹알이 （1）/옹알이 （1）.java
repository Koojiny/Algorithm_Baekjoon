class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] check = {"aya", "ye", "woo", "ma"};
        
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < check.length; j++) {
                babbling[i] = babbling[i].replace(check[j], " ");
            }
            
            // if (babbling[i].equals("")) answer++;
            if(babbling[i].trim().length() == 0){
                answer++;
            }
        }
        
        return answer;
    }
}