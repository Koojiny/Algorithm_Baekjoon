import java.io.*;
import java.util.*;

public class Main {

    public static Stack<Integer> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            solution(br.readLine());
        }
        System.out.println(sb);
    }

    public static void solution(String cmd) {
        char c = cmd.charAt(0);

        switch (c) {
            case '1':
                stack.push(Integer.parseInt(cmd.substring(2)));
                return;

            case '2':
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                return;

            case '3':
                sb.append(stack.size()).append('\n');
                return;

            case '4':
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                return;

            case '5':
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
                return;

            default: break;
        }
    }
}