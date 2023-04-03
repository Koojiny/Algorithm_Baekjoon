import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 첫 줄에 들어오는 값 n

        Stack<Integer> stack = new Stack<>(); // stack 객체 생성 (1 ~ n 넣음)
        ArrayList<String> result = new ArrayList<>(); // + - 결과를 반환할 배열 생성

        int[] arr = new int[n]; // 주어진 수열을 넣기 위한 크기 n짜리 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int arr_idx = 0; // 수열값과 스택 top 값을 비교하기 위한 index

        for (int i = 1; i <= n; i++) {
            stack.push(i); // stack에 1부터 n까지 넣음
            result.add("+"); // push 할 때마다 + 추가
            while (!stack.isEmpty()) { // stack이 비어 있지 않다면
                if (stack.peek() == arr[arr_idx]) {
                    stack.pop();
                    result.add("-");
                    arr_idx++;
                } else break;
            }
        }
        if (stack.isEmpty()) { // for문을 빠져나온 후 스택이 비어있다면 result 값을 출력
            for (String s : result) System.out.println(s);
        } else System.out.println("NO"); // 스택에 값이 남아있다면 수열 실패로 NO 출력
    }
}
