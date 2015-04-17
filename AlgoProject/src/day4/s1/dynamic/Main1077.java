package day4.s1.dynamic;

import java.util.Scanner;

public class Main1077 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int targetWeight = sc.nextInt();		
		int[] weights = new int[n+1];
		int[] benefits = new int[n+1];
		
		// i=0부분은 처리에서 제외
		for (int i = 1; i <n+1; i++) {
			weights[i] = sc.nextInt();
			benefits[i] = sc.nextInt();
		}
		sc.close();
		
		int[][] results = new int[n+1][targetWeight+1];		
		for (int item = 1; item < n+1; item++) {
			for (int weight = 1; weight < targetWeight+1; weight++) {
				if(weights[item] <= weight){
					results[item][weight] = Math.max(results[item-1][weight], 
							benefits[item]*(weight/weights[item])
							+results[item-1][weight-(weights[item]*weight/weights[item])]);
				}else{
					results[item][weight] =  results[item-1][weight];
				}
			}
		}		
		System.out.println(results[n][targetWeight]);
		sc.close();
	}

}
