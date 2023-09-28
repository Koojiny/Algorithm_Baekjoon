import java.io.*;

public class Main {
    public static char[] c;
    public static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            int num = (int) Math.pow(3, N);
            sb = new StringBuilder();

            c = new char[num];
            for (int i = 0; i < num; i++) {
                c[i] = '-';
            }

            recursion(0, num);

            for (int i = 0; i < num; i++) {
                sb.append(c[i]);
            }
            System.out.println(sb);
        }
    }

    public static void recursion(int start, int length) {
        if (length == 1) {
            return;
        }
        // 3등분 중 중간을 공백으로 바꾸기
        for (int i = start + length / 3; i < start + length / 3 * 2; i++) {
            c[i] = ' ';
        }
        // 3등분 중 첫 번째, 세 번째 확인
        recursion(start, length / 3);
        recursion(start + length / 3 * 2, length / 3);
    }
}