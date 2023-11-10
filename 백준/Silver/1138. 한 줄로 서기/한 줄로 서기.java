import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = N; i > 0; i--) {
            if (numArr[i] == 0) {
                list.addFirst(i);
                continue;
            }
            list.add(numArr[i], i);
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}