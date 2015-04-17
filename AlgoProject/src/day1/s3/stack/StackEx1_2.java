package day1.s3.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackEx1_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String msg = s.nextLine();

		long start = System.nanoTime();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < msg.length(); i++) {
			stack.push(msg.charAt(i));
		}
		for (int i = 0; i < msg.length(); i++) {
			System.out.print(stack.pop());
		}
		long end = System.nanoTime();
		System.out.println();
		System.out.println("걸린시간 : " + (end - start) + "ns");
		s.close();
	}
}
// fkldfaewnkdkldkdafdmfklfklaf opajemlakmdlfka;l jfelkamdlkfa
// 4445891