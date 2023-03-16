import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] meet;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		meet = new int[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				meet[i][j] = sc.nextInt();
			}
		}

		Arrays.sort(meet, (x, y) -> x[1] != y[1]? x[1] - y[1] : x[0] - y[0]);
		
		count = 0;
		int pre_end = 0;
		
		for (int i = 0; i < N; i++) {
			if (pre_end <= meet[i][0]) {
				pre_end = meet[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
}