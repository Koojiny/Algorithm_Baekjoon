import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        while (true) {
            String line = br.readLine();
            if (line.equals("#")) break;
            int cnt = 0;

            for (int i = 0; i < line.length(); i++) {
                for (char c : arr) {
                    if (c == line.charAt(i)) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}