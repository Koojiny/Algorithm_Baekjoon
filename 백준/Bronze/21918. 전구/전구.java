import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lights = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            switch (first) {
                case 1:
                    lights[second] = third;
                    break;
                case 2:
                    for (int j = second; j <= third; j++) {
                        if (lights[j] == 1) lights[j] = 0;
                        else lights[j] = 1;
                    }
                    break;
                case 3:
                    for (int j = second; j <= third; j++) {
                        lights[j] = 0;
                    }
                    break;
                case 4:
                    for (int j = second; j <= third; j++) {
                        lights[j] = 1;
                    }
                    break;
            }
        }

        for (int j = 1; j <= N; j++) {
            System.out.print(lights[j] + " ");
        }
    }
}