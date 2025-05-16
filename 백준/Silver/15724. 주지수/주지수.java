import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] jujisu = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                jujisu[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                jujisu[i + 1][j] = jujisu[i][j] + jujisu[i + 1][j];
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                jujisu[i][j + 1] = jujisu[i][j] + jujisu[i][j + 1];
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(jujisu[x2][y2] - jujisu[x2][y1 - 1] - jujisu[x1 - 1][y2] + jujisu[x1 - 1][y1 - 1]);
        }
    }
}