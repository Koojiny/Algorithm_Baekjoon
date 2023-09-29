import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str= br.readLine()) != null) {
            if (str.equals("END")) break;
            String newStr = new StringBuilder(str).reverse().toString();
            System.out.println(newStr);
        }
    }
}