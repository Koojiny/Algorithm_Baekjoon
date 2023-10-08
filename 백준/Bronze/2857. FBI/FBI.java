import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String spyName = br.readLine();
            if (spyName.contains("FBI")) sb.append(i + 1).append(' ');
        }
        if (sb.length() == 0) System.out.println("HE GOT AWAY!");
        else System.out.println(sb);
    }
}