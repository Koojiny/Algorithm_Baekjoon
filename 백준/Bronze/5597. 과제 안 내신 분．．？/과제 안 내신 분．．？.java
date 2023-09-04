import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] student = new boolean[30];
        int[] result = new int[30];

        for (int i = 0; i < 28; i++) {
            student[Integer.parseInt(br.readLine()) - 1] = true;
        }
        
        for (int i = 0; i < 30; i++) {
            if (student[i] == false) {
                result[i] = i + 1;
            }
        }
        Arrays.sort(result);
        
        System.out.println(result[28]);
        System.out.println(result[29]);
    }
}