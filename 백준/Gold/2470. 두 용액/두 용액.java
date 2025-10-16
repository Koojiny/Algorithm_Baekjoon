import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int ansLeft = left;
        int ansRight = right;

        long min = Long.MAX_VALUE;
        while (left < right) {
            long sum = arr[left] + arr[right];
            long absSum = Math.abs(sum);

            // 절대값이 가장 작은 것 비교
            if (absSum < min) {
                min = absSum;
                ansLeft = left;
                ansRight = right;
            }

            if (sum > 0) right--;
            else left++;
        }

        System.out.println(arr[ansLeft] + " " + arr[ansRight]);
    }
}