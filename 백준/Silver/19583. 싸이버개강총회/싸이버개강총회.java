import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        int start = Integer.parseInt(S.split(":")[0]) * 60 + Integer.parseInt(S.split(":")[1]);
        int end = Integer.parseInt(E.split(":")[0]) * 60 + Integer.parseInt(E.split(":")[1]);
        int quit = Integer.parseInt(Q.split(":")[0]) * 60 + Integer.parseInt(Q.split(":")[1]);

        Set<String> enter = new HashSet<>();
        Set<String> exit = new HashSet<>();
        String s;

        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            String cur = st.nextToken();
            String name = st.nextToken();
            int time = Integer.parseInt(cur.split(":")[0]) * 60 + Integer.parseInt(cur.split(":")[1]);

            if (time <= start) enter.add(name);
            if (end <= time && time <= quit && enter.contains(name)) exit.add(name);
        }

        System.out.println(exit.size());
    }
}