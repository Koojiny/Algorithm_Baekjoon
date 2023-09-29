import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
                arr[i] = c;
            } else {
                c = Character.toUpperCase(c);
                arr[i] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}