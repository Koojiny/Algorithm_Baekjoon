import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (arr[c - 'a'] == -1) arr[c- 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}