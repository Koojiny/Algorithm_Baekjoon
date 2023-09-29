class Solution {
    public int solution(int[] array) {
        int[] arr = new int[1000];
        
        for (int i = 0; i < array.length; i++){
            arr[array[i]]++; // 해당하는 인덱스와 일치하는 값이 있다면 arr의 해당 배열을 +1
        }
        
        int max = -9999;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                answer = i;
            } else if (max == arr[i]) {
                answer = -1;
            }
        }
        
        return answer;
    }
}