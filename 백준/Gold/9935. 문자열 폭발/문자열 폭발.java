import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        int strLen = str.length();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        // str 길이만큼 반복
        for (int i = 0; i < strLen; i++) {
            int count = 0;
            stack.push(str.charAt(i)); // 문자 하나씩 순서대로 넣는다

            if (stack.size() >= bombLen) { // 스택의 크기가 폭발 문자열 길이 이상이 되면 비교 시작
                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) == bomb.charAt(j)) {
                        count++;
                    }

                    if (count == bombLen) {
                        for (int k = 0; k < bombLen; k++) {
                            stack.pop();
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char c : stack) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}