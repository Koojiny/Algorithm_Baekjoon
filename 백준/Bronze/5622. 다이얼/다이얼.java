import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int time = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'A' || c == 'B' || c == 'C') time += 3;
            if (c == 'D' || c == 'E' || c == 'F') time += 4;
            if (c == 'G' || c == 'H' || c == 'I') time += 5;
            if (c == 'J' || c == 'K' || c == 'L') time += 6;
            if (c == 'M' || c == 'N' || c == 'O') time += 7;
            if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') time += 8;
            if (c == 'T' || c == 'U' || c == 'V') time += 9;
            if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') time += 10;
        }
        System.out.println(time);
    }
}