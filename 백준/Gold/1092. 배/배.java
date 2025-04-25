import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        if (boxes[0] > cranes[0]) {
            System.out.println(-1);
            return;
        }

        List<Integer> boxList = new ArrayList<>(Arrays.asList(boxes));
        int time = 0;

        while (!boxList.isEmpty()) {
            int craneIndex = 0;
            ListIterator<Integer> iter = boxList.listIterator();

            while (iter.hasNext() && craneIndex < N) {
                int currentBox = iter.next();
                if (cranes[craneIndex] >= currentBox) {
                    iter.remove(); // 박스 제거
                    craneIndex++;  // 다음 크레인
                }
            }

            time++;
        }

        System.out.println(time);
    }
}
