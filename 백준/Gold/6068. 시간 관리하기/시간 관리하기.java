import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Work[] works = new Work[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            works[i] = new Work(time, end);
        }

        // 종료시간 기준 내림차순
        Arrays.sort(works);

        int start = works[0].end;
        int idx = 0;

        while (idx < N) {
            if (start > works[idx].end) {
                start = works[idx].end;
            }
//            System.out.println("idx= " + idx + ", start=" + start + ", time=" + works[idx].time);

            start = start - works[idx].time;

            if (start < 0) {
                System.out.println(-1);
                return;
            }

            idx++;
        }

        System.out.println(start);
    }

    static class Work implements Comparable<Work> {
        int time;
        int end;

        public Work(int time, int end) {
            this.time = time;
            this.end = end;
        }

        @Override
        public int compareTo(Work o) {
            return o.end - this.end;
        }
    }
}
