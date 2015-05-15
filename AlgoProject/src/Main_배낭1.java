

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_¹è³¶1{
	public static final int WEIGHT = 0;
	public static final int VALUE = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int W = sc.nextInt();
		int jewels[][] = new int[N][2];
		int dp[] = new int[W];
		
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
		

		if(jewels[0][WEIGHT] == 1) {
			dp[0] = jewels[0][VALUE];
		}
		int newValue = 0;
		for(int i = 1; i < W; i++) {
			for(int j = 0; j < N; j++) {
				if(i + 1 >= jewels[j][WEIGHT]) {
					if(i - jewels[j][WEIGHT] >= 0) {
						newValue = dp[i - jewels[j][WEIGHT]] + jewels[j][VALUE];
					}  else {
						newValue = jewels[j][VALUE];
					}
					
					dp[i] = Math.max(dp[i], newValue);
				}
			}
		}
		
		for(int j = 1; j <= W; j++) { 
			System.out.printf("%4d", j);
		}
		System.out.println();
		for(int j = 0; j < W; j++) { 
			System.out.printf("%4d", dp[j]);
		}
		System.out.println();
		
		System.out.println(dp[W - 1]);
		sc.close();
	}
}
