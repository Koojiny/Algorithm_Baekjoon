import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String start = "" + s.charAt(i);
            dfs(i, i, start, start);
        }

        System.out.println(set.size());
    }

    static void dfs(int left, int right, String cur, String path) {
        if (left == 0 && right == s.length() - 1) {
            set.add(path);
            return;
        }

        if (left > 0) {
            String next = s.charAt(left - 1) + cur;
            dfs(left - 1, right, next, path + " " + next);
        }

        if (right < s.length() - 1) {
            String next = cur + s.charAt(right + 1);
            dfs(left, right + 1, next, path + " " + next);
        }
    }
}