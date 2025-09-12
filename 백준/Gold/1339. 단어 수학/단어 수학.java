import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alphabet = new int[26]; // 각 알파벳의 가중치를 계산할 배열
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                alphabet[c - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }

        Arrays.sort(alphabet);

        int sum = 0;
        int num = 9;
        for (int i = 25; i >= 0 ; i--) {
            if (alphabet[i] == 0) break;
            sum += alphabet[i] * num;
            num--;
        }

        System.out.println(sum);
    }
}