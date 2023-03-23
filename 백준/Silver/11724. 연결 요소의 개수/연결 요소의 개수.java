import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer>[] adjList;
	static int N, E;
	static boolean[] visited;
	static int cnt, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList();
		}
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		result = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				DFS(i);
				result++;				
			}
		}
		System.out.println(result);
	}
	
	private static void DFS(int currNode) {
//		System.out.print(currNode);
		visited[currNode] = true;
		for (int node : adjList[currNode]) {
			if (!visited[node]) {
				visited[node] = true;
				DFS(node);
			}
		}
	}
}