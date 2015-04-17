package day2.s3.sort;

import java.util.Scanner;

public class Main1146 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] ia = new int[num];
		for (int i = 0; i < num; i++) {
			ia[i] = s.nextInt();
		}
		
		for (int i = 0; i < num - 1; i++) {
			int temp = i;
			for (int k = i + 1; k < num; k++) {
				if (ia[k] < ia[temp]) {
					temp = k;
				}
			}
			int swap = ia[i];
			ia[i] = ia[temp];
			ia[temp] = swap;
			for (int k = 0; k < num; k++)
				System.out.print(ia[k] + " ");
			System.out.println();
		}
		s.close();
	}
}
