import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] numArr;
    public static boolean[] visited;
    public static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1부터 N까지 각 인덱스에 입력받은 숫자 저장
        numArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>(); // 사이클이 만들어지는 숫자 저장 리스트
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int start, int target) {
        if (visited[numArr[start]] == false) {
            visited[numArr[start]] = true;
            dfs(numArr[start], target);
            visited[numArr[start]] = false;
        }

        if (numArr[start] == target) list.add(target); // 현재 값이 타겟과 동일하다면 사이클 완성 -> 리스트에 저장
    }
}
