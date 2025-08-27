import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr.add(0L);
        for (int num = 1; num <= 9; num++) {
            dfs(num, num);
        }

        Collections.sort(arr);

        if (n >= arr.size()) System.out.println(-1);
        else System.out.println(arr.get(n));
    }

    public static void dfs(long cur, int lastDigit) { // cur : 현재까지 만든 감소하는 수, lastDigit : 현재 수의 마지막 자리
        arr.add(cur);

        for (int next = 0; next < lastDigit; next++) {
            dfs(cur * 10 + next, next);
        }
    }
}