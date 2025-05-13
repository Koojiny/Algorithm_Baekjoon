import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lan = new long[k];

        for (int i = 0; i < k; i++) {
            lan[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(lan);

        long low = 1;
        long high = lan[k - 1];
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (int i = 0; i < k; i++) {
                count += lan[i] / mid;
            }

            if (count >= n) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}