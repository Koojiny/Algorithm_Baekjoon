import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        String answer = "";
        String[] sArr = {"7", "4"};

        while (K > 0) {
            int temp = K % 2;
            if (temp == 0) {
                K--;
            }
            answer = sArr[temp] + answer;

            K = K / 2;
        }

        System.out.println(answer);
    }
}