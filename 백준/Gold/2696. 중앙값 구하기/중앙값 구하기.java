import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());

            int[] arr = new int[M];
            List<Integer> result = new ArrayList<>();
            StringTokenizer st = null;
            int idx = 0;
            while (idx < M) {
                if (idx % 10 == 0) st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr[idx] = Integer.parseInt(st.nextToken());

                    if (idx % 2 == 0) {
                        Arrays.sort(arr, 0, idx + 1);
                        result.add(arr[idx / 2]);
                    }
                    idx++;
                }
            }

            // 출력하는 중앙값 개수 출력
            System.out.println(result.size());
            // 중앙값 차례대로 출력
            int cnt = 0;
            for (int j = 0; j < result.size(); j++) {
                System.out.print(result.get(j) + " ");
                cnt++;
                if (cnt % 10 == 0) System.out.println();
            }
            System.out.println();
        }
    }
}
