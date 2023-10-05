import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N.length(); i++) {
            int target = N.charAt(i) - '0';
            String s = Integer.toBinaryString(target);

            if (s.length() == 3) {
                sb.append(s);
            } else if (s.length() == 2 && i != 0) {
                sb.append("0" + s);
            } else if (s.length() == 1 && i != 0) {
                sb.append("00" + s);
            } else {
                sb.append(s);
            }
        }
        System.out.println(sb);
    }
}