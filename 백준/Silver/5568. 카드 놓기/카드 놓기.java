import java.io.*;
import java.util.*;

public class Main {

    public static int n, k;
    public static boolean[] visit;
    public static String[] arr;
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        visit = new boolean[n];

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        dfs("", 0);

        System.out.print(set.size());
    }

    public static void dfs(String temp, int count) {
        if (k == count) {
            set.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(temp + arr[i], count + 1);
                visit[i] = false;
            }
        }
    }
}