import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, L, R;
    public static int[][] land;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        land = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            // 1. 국경선 열기
            // 국경선 확인 시 안 열렸을 경우 탈출
            // 2. 인구 이동
            if (!openDoor()) break;

            // 3. 발생일수 + 1
            days++;
        }

        System.out.println(days);
    }

    private static boolean openDoor() {
        boolean isMoved = false;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    // BFS 탐색용 큐
                    Queue<int[]> q = new LinkedList<>();
                    // 연합 포함된 칸 저장 큐
                    Queue<int[]> union = new LinkedList<>();

                    q.offer(new int[]{i, j});
                    union.offer(new int[]{i, j});
                    visited[i][j] = true;

                    int totalPopulation = land[i][j]; // 총 인구 수
                    int count = 1; // 연합 크기

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];

                            if (inRange(nx, ny) && !visited[nx][ny]) {
                                int diff = Math.abs(land[nx][ny] - land[x][y]);
                                if (diff >= L && diff <= R) {
                                    q.offer(new int[]{nx, ny});
                                    union.offer(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                    totalPopulation += land[nx][ny];
                                    count++;
                                }
                            }
                        }
                    }

                    if (count > 1) {
                        int newPopulation = totalPopulation / count;
                        for (int[] pos : union) {
                            land[pos[0]][pos[1]] = newPopulation;
                        }
                        isMoved = true;
                    }
                }
            }
        }

        return isMoved;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
