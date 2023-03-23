import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		
		BFS(0, 0);
		System.out.println(arr[N - 1][M - 1]);
	}
	
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] {i, j});
		visited[i][j] = true; // 방문한 노드 true로 변경
		
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (arr[nx][ny] != 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						arr[nx][ny] = arr[now[0]][now[1]] + 1;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
}