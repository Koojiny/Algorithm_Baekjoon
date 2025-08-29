import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] miro;
    public static int x, y; // 현재 좌표
    public static int brokenWall;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        x = 0;
        y = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, 0));
        visited[x][y] = true;

        int nx, ny;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                brokenWall = cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (!inRange(nx, ny)) continue;

                if (!visited[nx][ny] && miro[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, cur.cnt));
                }

                if (!visited[nx][ny] && miro[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }

        System.out.println(brokenWall);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node other) {
        return this.cnt - other.cnt;
    }
}