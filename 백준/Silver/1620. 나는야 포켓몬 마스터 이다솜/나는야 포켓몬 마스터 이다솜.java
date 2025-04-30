import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String[] pArr = new String[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String pokemon = br.readLine();
            map.put(pokemon, i);
            pArr[i] = pokemon;
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                System.out.println(map.get(s));
            } else {
                System.out.println(pArr[Integer.parseInt(s)]);
            }
        }
    }
}