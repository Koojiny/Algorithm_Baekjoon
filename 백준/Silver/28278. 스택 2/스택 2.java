import java.io.*;
import java.util.*;

public class Main {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            switch (cmd.charAt(0)) {
                case '1':
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case '2':
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                    break;

                case '3':
                    sb.append(stack.size()).append('\n');
                    break;

                case '4':
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;

                case '5':
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}