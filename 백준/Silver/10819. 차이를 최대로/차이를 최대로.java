import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, sum, max; // input N, 합, 최댓값
    static int[] arr; // input
    static int[] numbers; // 숫자 조합 넣을 배열
    static boolean isSelected[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        numbers = new int[N];
        isSelected = new boolean[N];
//        System.out.println(Arrays.toString(arr));

        max = 0;

        permutation(0);

        System.out.println(max);
    }

    private static void permutation(int idx) {
        if (idx == N) {
//            System.out.println(Arrays.toString(numbers));
            sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(numbers[i] - numbers[i + 1]);
            }
//            System.out.println(sum);
            if (max < sum) max = sum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            int num = arr[i];

            numbers[idx] = num;
            isSelected[i] = true;
            permutation(idx + 1);
            isSelected[i] = false;
        }
    }
}
