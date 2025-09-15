import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        // 세미콜론 제거
        str = str.substring(0, str.length() - 1);

        String[] tokens = str.split(" ");

        // 기본 타입
        String baseType = tokens[0];

        for (int i = 1; i < tokens.length; i++) {
            String var = tokens[i];

            // 끝에 콤마 있으면 제거
            if (var.charAt(var.length() - 1) == ',') {
                var = var.substring(0, var.length() - 1);
            }

            StringBuilder name = new StringBuilder(); // 변수명
            StringBuilder suffix = new StringBuilder(); // 수식자

            for (int j = 0; j < var.length(); j++) {
                char c = var.charAt(j);

                // 알파벳, 숫자, 언더바
                if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '_') {
                    name.append(c);
                } else {
                    // 수식자 처리
                    if (c == '[') {
                        suffix.insert(0, ']');
                    } else if (c == ']'){
                        suffix.insert(0, '[');
                    } else {
                        suffix.insert(0, c);
                    }
                }
            }

            System.out.println(baseType + suffix + " " + name + ";");
        }
    }
}
