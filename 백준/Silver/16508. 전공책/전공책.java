import java.io.*;
import java.util.*;

public class Main {
    static int N; // 전공책 개수
    static int min = Integer.MAX_VALUE; // 최소 총액
    static String word;
    static int[] alphabetCount, selectCount = new int[26]; // 필요한 알파벳 개수, 사용한 알파벳 개수
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        books = new ArrayList<>();
        alphabetCount = new int[26];

        // 1. 필요한 알파벳 개수를 각 알파벳 인덱스별로 저장
        for (int i = 0; i < word.length(); i++) {
            alphabetCount[word.charAt(i) - 'A']++;
        }

        // 2. 책 가격과 문자열을 저장
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            books.add(new Book(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        // 3. 각 문자열을 모두 돌면서 해당하는 알파벳을 탐색
        dfs(0, 0);

        // 4. 최소 총액을 반환
        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    static void dfs(int depth, int totalPrice) {
        // 1. 탈출 조건 (N개의 책을 모두 탐색, 알파벳을 모두 구했다면, 최솟값 계산하여 갱신)
        if (depth == N) {
            if (check()) {
                min = Math.min(min, totalPrice);
            }
            return;
        }

        // 2. 수행 동작
        // 현재 depth의 책을 선택하는 경우
        // 현재 depth의 책 제목을 구성하는 알파벳의 배열 값을 모두 1 추가하고 depth 1 증가
        // 총액은 현재 depth의 책 가격만큼 증가시킴
        for (int i = 0; i < books.get(depth).title.length(); i++) {
            selectCount[books.get(depth).title.charAt(i) - 'A']++;
        }
        dfs(depth + 1, totalPrice + books.get(depth).price);

        // 현재 depth의 책을 선택하지 않는 경우
        // 이전에 증가시킨 배열 값을 모두 초기화, 총액은 이전값 그대로 유지하여 넘긴다
        for (int i = 0; i < books.get(depth).title.length(); i++) {
            selectCount[books.get(depth).title.charAt(i) - 'A']--;
        }
        dfs(depth + 1, totalPrice);
    }

    static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] > selectCount[i]) {
                return false;
            }
        }
        return true;
    }
}

class Book {
    int price;
    String title;

    Book(int price, String title) {
        this.price = price;
        this.title = title;
    }
}
