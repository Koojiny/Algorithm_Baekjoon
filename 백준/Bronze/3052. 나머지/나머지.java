import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[42];

        for (int i = 0; i < 10; i++) {
            arr[Integer.parseInt(br.readLine()) % 42] = true;
        }
        
        int result = 0;
        for (boolean data : arr) {
            if (data) {
                result++;
            }
        }
        System.out.println(result);
    }
}