import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        int[] alphabetCnt = new int[26];

        for (int i = 0; i < word.length(); i++) {
            alphabetCnt[word.charAt(i) - 'A'] += 1;
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < alphabetCnt.length; i++) {
            if (max < alphabetCnt[i]) {
                max = alphabetCnt[i];
                answer = (char) (i + 'A');
            } else if (max == alphabetCnt[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}