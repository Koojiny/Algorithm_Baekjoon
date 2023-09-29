import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String revA = "";
        String revB = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            revA = revA + a.charAt(i);
            revB = revB + b.charAt(i);
        }
        String res = (Integer.parseInt(revA) > Integer.parseInt(revB) ? revA : revB);
        System.out.println(res);
    }
}