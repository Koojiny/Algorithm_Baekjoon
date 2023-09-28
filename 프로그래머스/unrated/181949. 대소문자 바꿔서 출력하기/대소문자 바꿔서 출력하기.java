import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // String res = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (Character.isUpperCase(c)) {
                // res += Character.toLowerCase(c);
                sb.append(Character.toLowerCase(c));
            } else {
                // res += Character.toUpperCase(c);
                sb.append(Character.toUpperCase(c));
            }
        }
        // System.out.println(res);
        System.out.println(sb);
    }
}