import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Time[] times = new Time[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            times[i] = new Time(t, s);
        }

        Arrays.sort(times);

        int endTime = times[0].end;

        for (Time time : times) {
            // 최대 가능한 종료 시간이 실제 끝내야하는 시간보다 늦으면 실제 끝내야하는 시간으로 갱신
            if (endTime > time.end) {
                endTime = time.end;
            }
            endTime -= time.time;
            
            if (endTime < 0) {
                System.out.println(-1);
                return;
            }
        }
        
        System.out.println(endTime);
    }

    static class Time implements Comparable<Time> {
        int time;
        int end;

        public Time(int time, int end) {
            this.time = time;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return o.end - this.end;
        }
    }
}
