import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
    
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        //System.out.println(Arrays.toString(arr));
        
        Arrays.sort(arr, (x, y) -> (y + x).compareTo(x + y));
        
        if (arr[0].equals("0")) { return "0";}
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }
        return answer.toString();
    }
}