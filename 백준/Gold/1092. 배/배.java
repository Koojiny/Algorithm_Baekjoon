import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i]= Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Integer[] box = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box[i]= Integer.parseInt(st.nextToken());
        }
        // 내림차순 정렬
        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());

        // 가장 첫 번째 크레인 무게 제한보다 가장 무거운 박스가 더 무겁다면 무조건 1개는 남는다
        if (crane[0] < box[0]) {
            System.out.println(-1);
            return;
        }

        int count = 0; // 처리된 박스 개수
        int time = 0; // 소요된 시간(크레인 한바퀴 돌면 1분 추가)
        boolean[] move = new boolean[M];

        while (count < M) {
            int boxIdx = 0;

            for (int i = 0; i < N; i++) { // 크레인 확인
                while (boxIdx < M) {
                    // 아직 옮기지 않은 박스이고 크레인이 옮길 수 있는 경우
                    if (!move[boxIdx] && crane[i] >= box[boxIdx]) {
                        move[boxIdx] = true;    // 박스 옮김
                        count++;                // 옮긴 박스 수 증가
                        boxIdx++;               // 다음 박스에서 시작
                        break;
                    }
                    boxIdx++;
                }
            }
            time++; // 1분 추가
        }

        System.out.println(time);
    }
}