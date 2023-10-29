import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int party = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int countAll = people * party;
        for (int i = 0; i < 5; i++) {
            sb.append(Integer.parseInt(st.nextToken())- countAll).append(' ');
        }
        System.out.println(sb);
    }
}