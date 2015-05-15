import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_¹è³¶2 {
	public static final int WEIGHT = 0;
	public static final int VALUE = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int W = sc.nextInt();
		int jewels[][] = new int[N][2];
		int dp[][] = new int[N + 1][W + 1];
		
		for(int i = 0; i < N; i++) {
			jewels[i][WEIGHT] = sc.nextInt();
			jewels[i][VALUE] = sc.nextInt();
		}
		
		Arrays.sort(jewels, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[WEIGHT] - o2[WEIGHT] == 0) {
					return o2[VALUE] - o1[VALUE]; 
				} else {
					return o1[WEIGHT] - o2[WEIGHT];
				}
			}
		});
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= W; j++) { 
				if(j < jewels[i - 1][WEIGHT]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1][j - jewels[i - 1][WEIGHT]] + jewels[i - 1][VALUE]);
				}
			}
		}
		System.out.printf("    ");
		for(int j = 1; j <= W; j++) { 
			System.out.printf("%4d", j);
		}
		System.out.println();
		for(int i = 1; i <= N; i++) {
			System.out.printf("%4d", jewels[i - 1][WEIGHT]);
			for(int j = 1; j <= W; j++) { 
				System.out.printf("%4d", dp[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(dp[N][W]);
		sc.close();
	}
}
