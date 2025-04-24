import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int plus = 0;
        int minus = 0;
        boolean flag = true;
        s = "+" + s;

        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (temp == '+' || temp == '-') { // 현재 값이 + 또는 - 인 경우
                if (!num.equals("")) { // 빈 값이 아니라면 + - 여부에 따라 값을 나누어 더해준다
                    if (flag) {
                        plus += Integer.parseInt(num);
                    } else {
                        minus += Integer.parseInt(num);
                    }
                }
                num = ""; // 더해준 값은 초기화
                if (temp == '-') {
                    flag = false; // 이제부턴 모두 빼기
                }
            } else {
                num += temp;
            }
        }

        // 마지막 숫자 처리
        if (!num.equals("")) {
            if (flag) {
                plus += Integer.parseInt(num);
            } else {
                minus += Integer.parseInt(num);
            }
        }

        System.out.println(plus - minus);
    }
}