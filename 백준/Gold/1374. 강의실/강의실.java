import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(num, start, end);
        }

        Arrays.sort(rooms);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(rooms[0].end);

        for (int i = 1; i < n; i++) {
            if (rooms[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(rooms[i].end);
        }

        System.out.println(pq.size());
    }
}

class Room implements Comparable<Room> {
    int num;
    int start;
    int end;

    public Room(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room other) {
        return this.start - other.start;
    }
}