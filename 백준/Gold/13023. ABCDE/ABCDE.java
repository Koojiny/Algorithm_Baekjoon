import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>(); // N개의 빈 리스트로 채움
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a); // 무방향 그래프이기 때문에 추가
		}
		
		for (int i = 0; i < N; i++) {
			
			DFS(i, 1);
			
			if (result > 0) break;
		}
		
		System.out.println(result);
	}
	
	private static void DFS(int curr, int depth) {
		if (depth == 5) {
			result = 1;;
			return;
		}
		visited[curr] = true; // 재귀 돌기 전에 현재 노드를 방문처리
		for (int node : arr[curr]) {
			if (!visited[node]) {
				visited[node] = true;
				DFS(node, depth + 1);
			}
		}
		visited[curr] = false; // 재귀를 빠져나가면서 main에서 돌아야할 재귀를 위해 false 처리
	}
}
