package day1.s2.bit;

import java.util.Scanner;

public class Main1419 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();

		long n1 = n & 255;
		long n2 = (n >> 8) & 255;
		long n3 = (n >> 16) & 255;
		long n4 = (n >> 24) & 255;

		long nn = (n1 << 24 | n2 << 16 | n3 << 8 | n4);
		System.out.println(nn);
		s.close();
	}
}

/*
 * 
예제 입력 
2018915346



예제 출력 
305419896

*/
