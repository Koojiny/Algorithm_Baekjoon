import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> hash1 = new HashMap<>();
        Map<Integer, String> hash2 = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            String pokemon = br.readLine();
            hash1.put(pokemon, i);
            hash2.put(i, pokemon);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (hash1.containsKey(s)) {
                System.out.println(hash1.get(s));
            } else {
                System.out.println(hash2.get(Integer.parseInt(s)));
            }
        }
    }
}