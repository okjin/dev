package day1.s3.stack;

import java.util.Scanner;

public class StackEx1_3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String msg = s.nextLine();

		long start = System.nanoTime();
		StringBuilder sb = new StringBuilder(msg);
		System.out.println(sb.reverse());
		long end = System.nanoTime();
		System.out.println();
		System.out.println("걸린시간 : " + (end - start) + "ns");
		s.close();
	}
}
// fkldfaewnkdkldkdafdmfklfklaf opajemlakmdlfka;l jfelkamdlkfa
// 986471