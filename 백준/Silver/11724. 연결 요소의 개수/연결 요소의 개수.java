import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) { // 인접 리스트 초기화
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end); // 양방향이므로 양쪽에 방향을 더해주자
            A[end].add(start);
        }

        int cnt = 0; // 연결 요소의 개수
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int v) {
        if (visited[v]) return; // 방문한 노드라면 바로 리턴
        visited[v] = true;

        for (int i : A[v]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }
}