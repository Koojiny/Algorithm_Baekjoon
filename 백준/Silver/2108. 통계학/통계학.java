import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        AverageNum(arr);

        Arrays.sort(arr);
        System.out.println(arr[N / 2]);
        ModeNum(arr);
        System.out.println(arr[N - 1] - arr[0]);

    }

    static void AverageNum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        int avg = 0;
        avg = (int) Math.round((double) sum / N);
        System.out.println(avg);
    }

    static void ModeNum(int[] arr) {
        int[] cnt = new int[8001];
        int max = 0;

        for (int i = 0; i < N; i++) {
            cnt[arr[i] + 4000]++;
            max = Math.max(cnt[arr[i] + 4000], max);
        }

        ArrayList<Integer> max_idx = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (max == cnt[i]) {
                max_idx.add(i - 4000);
            }
        }

        System.out.println(max_idx.size() > 1 ? max_idx.get(1) : max_idx.get(0));
    }
}
