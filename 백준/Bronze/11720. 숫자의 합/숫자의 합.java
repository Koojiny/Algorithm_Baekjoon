import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String sNumber = bf.readLine(); // String으로 먼저 주어진 숫자를 받아온다
        char[] cNumber = sNumber.toCharArray(); // 받아온 숫자를 char 로 변환하여 배열에 저장

        int sum = 0; // 배열의 각 인덱스의 값을 더하기 위한 변수
        for (int i = 0; i < N; i++) { // 배열 크기만큼 순회하며 각 배열의 값을 sum에 더한다
            sum += cNumber[i] - '0';
        }

        System.out.println(sum);
    }
}
