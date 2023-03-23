import java.util.Scanner;

public class Main {

	static int N, K, sum, count;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		count = 0; // 동전 갯수

		for (int i = N - 1; i >= 0; i--) {
			
			if (arr[i] <= K) { // 더한 값이 K보다 크면 넘어간다
				
				count += K / arr[i]; // 나눈 몫을 저장하면 해당 가치의 갯수가 저장된다
				K = K % arr[i]; // 나눈 나머지를 K에 저장하여 넘긴다
			}
		}
		
		System.out.println(count);
	}

}
