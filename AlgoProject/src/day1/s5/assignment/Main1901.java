package day1.s5.assignment;

import java.util.Scanner;

public class Main1901 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int m = s.nextInt();
			if (isPrime(m)) {
				System.out.println(m);
				continue;
			}
			for (int f = m - 1; f >= 2; f--) {
				boolean r1 = isPrime(f);
				int f2 = m + (m - f);
				boolean r2 = isPrime(f2);
				if (r1 && r2) {
					System.out.println(f + " " + f2);
					break;
				} else if (r1) {
					System.out.println(f);
					break;
				} else if (r2) {
					System.out.println(f2);
					break;
				}
			}
		}
		s.close();
	}
	public static boolean isPrime(int x) {
		if (x == 1) return false;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}

/*

입력 예:
2 
8 
15




출력예:
7 
13 17


*/