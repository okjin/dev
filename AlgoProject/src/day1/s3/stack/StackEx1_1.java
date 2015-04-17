package day1.s3.stack;

import java.util.Scanner;

public class StackEx1_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String msg = s.nextLine();

		long start = System.nanoTime();
		char[] ca = msg.toCharArray();
		for (int i = (ca.length - 1); i >= 0; i--) {
			System.out.print(ca[i]);
		}
		long end = System.nanoTime();
		System.out.println();
		System.out.println("걸린시간 : " + (end - start) + "ns");
		s.close();
	}
}
// fkldfaewnkdkldkdafdmfklfklaf opajemlakmdlfka;l jfelkamdlkfa
// 3086261