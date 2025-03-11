import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b) { //6 10
                // int num1 = Integer.parseInt(a + b); //610
                // int num2 = Integer.parseInt(b + a); //106
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        });
        
        if (arr[0].equals("0")) return "0";
        
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        
        return answer;
    }
}