import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String cur = br.readLine();
            if (cur.matches("^[A-F]?A+F+C+[A-F]?$")) System.out.println("Infected!");
            else System.out.println("Good");
        }
    }
}