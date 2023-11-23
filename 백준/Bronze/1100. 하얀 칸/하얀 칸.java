import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] chess = new String[8][8];

        int result = 0;
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                chess[i] = line.split("");
            }
        }

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) { // 홀수 줄
                for (int j = 0; j < 8; j += 2) {
                    if (chess[i][j].equals("F")) result++;
                }
            } else if (i % 2 == 1) { // 짝수 줄
                for (int j = 1; j < 8; j += 2) {
                    if (chess[i][j].equals("F")) result++;
                }
            }
        }
        System.out.println(result);
    }
}