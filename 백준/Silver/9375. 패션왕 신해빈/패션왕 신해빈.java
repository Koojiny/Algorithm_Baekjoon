import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String category = st.nextToken();

                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int cur = 1;
            for (String key : map.keySet()) {
                cur *= map.get(key) + 1;
            }
            
            System.out.println(cur - 1);
        }
    }
}