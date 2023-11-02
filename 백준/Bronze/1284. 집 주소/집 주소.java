import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String num = br.readLine();
            if (num.equals("0")) break;

            int width = 1;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c == '1') {
                    width += 2;
                } else if (c == '0') {
                    width += 4;
                } else {
                    width += 3;
                }
                width += 1;
            }
            System.out.println(width);
        }
    }
}