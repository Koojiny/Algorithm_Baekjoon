import java.io.*;
import java.util.*;

public class Main {
    public static int[] sArr, wArr; // 내구도, 무게
    public static int n, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sArr = new int[n]; // 내구도
        wArr = new int[n]; // 무게

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sArr[i] = Integer.parseInt(st.nextToken());
            wArr[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        breakEggs(0, 0);

        System.out.println(max);
    }

    public static void breakEggs(int idx, int brokenCnt) {
        // 모든 계란 확인한 경우
        if (idx == n) {
            max = Math.max(max, brokenCnt);
            return;
        }

        // 현재 계란이 이미 깨져있거나 나머지 게란이 다 깨져있는 경우 더 진행할 수 없으므로 다음 계란
        if (sArr[idx] <= 0 || brokenCnt == n - 1) {
            breakEggs(idx + 1, brokenCnt);
            return;
        }

        boolean hasTarget = false; // 칠 수 있는 계란 존재하는지 여부
        for (int i = 0; i < n; i++) {
            // 현재 들고 있는 계란과 같은 계란이거나 깨진 계란인 경우는 패스
            if (i == idx || sArr[i] <= 0) continue;

            hasTarget = true;
            // 이제부터 칠 수 있음
            // 계란끼리 부딪히기
            sArr[idx] -= wArr[i];
            sArr[i] -= wArr[idx];

            // 새로 깨진 계란 체크
            int newBroken = brokenCnt;
            if (sArr[idx] <= 0) newBroken++;
            if (sArr[i] <= 0) newBroken++;

            breakEggs(idx + 1, newBroken);

            // 복구
            sArr[idx] += wArr[i];
            sArr[i] += wArr[idx];
        }

        // 모든 계란을 확인했는데도 계란이 하나도 없는 경우
        if (!hasTarget) {
            breakEggs(idx + 1, brokenCnt);
        }
    }
}