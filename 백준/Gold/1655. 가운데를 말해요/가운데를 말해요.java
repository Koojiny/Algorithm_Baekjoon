import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 최대 힙 (현재 숫자보다 작은 절반)
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙 (현재 숫자보다 큰 절반)
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 왼쪽에는 무조건 1개 넣고 시작
            if (left.isEmpty() || left.peek() >= num) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()){
                left.offer(right.poll());
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.println(sb);
    }
}