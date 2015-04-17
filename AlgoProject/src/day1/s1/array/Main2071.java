package day1.s1.array;

import java.util.Scanner;

public class Main2071 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();// type

		int r = n + 1;
		int[][] ia = new int[r][r];
		ia[1][1] = 1;
		for (int i = 2; i < r; i++) {
			for (int j = 1; j <= i; j++) {
				ia[i][j] = ia[i - 1][j] + ia[i - 1][j - 1];
			}
		}
		switch (m) {
			case 1:
				for (int i = 1; i < r; i++) {
					for (int j = 1; j <= i; j++) {
						System.out.print(ia[i][j] + " ");
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 1; i < r; i++) {
					for (int sp = 1; sp < i; sp++) {
						System.out.print(" ");
					}
					for (int j = 1; j <= r - i; j++) {
						System.out.print(ia[r - i][j] + " ");
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 1; i < r; i++) {
					for (int j = i; j > 0; j--) {
						System.out.print(ia[j + (n - i)][j] + " ");
					}
					System.out.println();
				}
				break;
		}
		s.close();
	}
}
/*
 
6 1

*/