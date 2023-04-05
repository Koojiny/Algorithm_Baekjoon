import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int white = 0;
    static int blue = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N 값
        arr = new int[N][N]; // 2차원 배열 입력

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for (int i = 0; i < N; i++) {
//
//                System.out.println(Arrays.toString(arr[i]));
//        }

        cutPaper(0, 0, N); // 색종이 자르기, 시작 위치는 (0,0)부터, 사이즈는 주어진 크기부터
        System.out.println(white);
        System.out.println(blue);
    }

    static void cutPaper(int row, int col, int size) {
        // 자르고 난 후 색 체크
        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 0) white++;
            else blue++;
            return;
        }
        
        // 색종이를 잘라야 한다면 사분면으로 쪼개서 진행
        cutPaper(row, col, size/2);
        cutPaper(row, col + size/2, size/2);
        cutPaper(row + size/2, col, size/2);
        cutPaper(row + size/2, col + size/2, size/2);

    }

    static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col]; // 첫 번째로 주어지는 원소(좌상단)의 색을 기준으로 함

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) { // 무조건 정사각형이기 때문에 주어진 좌표에서 size 값 더함
                if (arr[i][j] != color) return false; // 해당 좌표가 color 값과 다르면 false
            }
        }

        return true; // 모든 좌표가 통과된 경우이므로 true
    }
}
