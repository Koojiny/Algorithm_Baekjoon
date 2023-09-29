class Solution {
    public int solution(int n, int k) {
        int service = n / 10; // 음료 서비스 받은 개수
        int yang = n * 12000; // 양꼬치 총 가격
        int coke = (k - service) * 2000;
        
        return yang + coke;
    }
}