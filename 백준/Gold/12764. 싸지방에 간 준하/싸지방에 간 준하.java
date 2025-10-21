import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Person(start, end));
        }
        // 시작 시간 기준으로 오름차순 정렬
        Collections.sort(list, (a, b) -> a.start - b.start);

        // 사용중인 컴퓨터 관리용 (빨리 끝나는 컴퓨터 순서)
        PriorityQueue<Computer> using = new PriorityQueue<>();
        // 빈자리 관리용 (번호 기준)
        PriorityQueue<Integer> available = new PriorityQueue<>();

        int[] computers = new int[N + 1];   // 자리별 사용 횟수
        int seatCount = 0;                  // 사용된 자리 수

        for (Person p : list) {
            // (1) 현재 시각 이전에 끝난 자리 반납
            while (!using.isEmpty() && using.peek().end <= p.start) {
                available.add(using.poll().number);
            }

            // (2) 자리가 있으면 재사용, 없으면 새 자리 추가
            int seat;
            if (!available.isEmpty()) {
                seat = available.poll(); // 번호 가장 작은 자리 재사용
            } else {
                seat = ++seatCount;      // 새로운 자리 배정
            }

            // (3) 자리 사용 횟수 증가 및 예약 추가
            computers[seat]++;
            using.add(new Computer(p.end, seat));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(seatCount).append("\n");
        for (int i = 1; i <= seatCount; i++) {
            sb.append(computers[i]).append(" ");
        }
        System.out.println(sb);
    }

    // 현재 사용중인 컴퓨터 정보
    static class Computer implements Comparable<Computer> {
        int end;
        int number;

        public Computer(int end, int comNumber) {
            this.end = end;
            this.number = comNumber;
        }

        @Override
        public int compareTo(Computer o) {
            return this.end - o.end;
        }
    }

    static class Person {
        int start;
        int end;

        public Person(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
