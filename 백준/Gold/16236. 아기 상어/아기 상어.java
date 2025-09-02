import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, sharkSize, time, eatCnt;
    public static int[][] space;
    public static boolean[][] visited;
    public static int[] dx  = {-1, 0, 1, 0}; // 상 우 하 좌
    public static int[] dy  = {0, -1, 0, 1};
    public static int sharkX, sharkY; // 상어의 현재 좌표

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        space = new int[n][n];

        sharkSize = 2;  // 초기 상어 사이즈
        time = 0;       // 총 걸린 시간
        eatCnt = 0;     // 먹은 물고기 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());;
                if (space[i][j] == 9) { // 상어 위치 확인
                    sharkX = i;
                    sharkY = j;
                    space[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish target = findFish();
            if (target == null) break; // 더 이상 먹을 수 있는 물고기 없음

            // 이동
            sharkX = target.x;
            sharkY = target.y;
            time += target.dist;
            eatCnt++;
            space[sharkX][sharkY] = 0; // 먹은 자리 비우기

            // 먹은 물고기 수가 상어 사이즈가 같아진 경우, 사이즈 + 1 & 먹은 물고기 수 0 초기화
            if (eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }
        }

        System.out.println(time);
    }

    public static Fish findFish() {
        visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        List<Fish> fishList = new ArrayList<>();

        q.add(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    int cell = space[nx][ny];

                    // 다음 칸의 값 확인
                    // 이동 가능 : 상어 크기보다 작거나 같아야 함
                    if (cell <= sharkSize) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, dist + 1});

                        // 먹을 수 있는 물고기 : 상어 크기보다 작을 때
                        if (cell > 0 && cell < sharkSize) {
                            fishList.add(new Fish(nx, ny, dist + 1));
                        }
                    }
                }
            }
        }

        if (fishList.isEmpty()) return null;
        Collections.sort(fishList); // 거리 -> 위쪽 -> 왼쪽 순서로 정렬 후 맨 앞의 물고기로 이동

        return fishList.get(0);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}

class Fish implements Comparable<Fish> {
    int x;
    int y;
    int dist;

    public Fish(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    // 정렬 기준: 거리 -> 위쪽 -> 왼쪽
    @Override
    public int compareTo(Fish other) {
        if (this.dist == other.dist) {
            if (this.x == other.x) return this.y - other.y;
            return this.x - other.x;
        }
        return this.dist - other.dist;
    }
}