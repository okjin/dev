package day1.s4.queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class QueueEx1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String msg = s.nextLine();

		long start = System.nanoTime();
		ArrayDeque<Character> deque = new ArrayDeque<Character>();
		for (int i = 0; i < msg.length(); i++) {
			deque.offerLast(msg.charAt(i));
		}
		Character ch = ' ';
		while ((ch = deque.pollLast()) != null) {
			System.out.print(ch);
		}
		long end = System.nanoTime();
		System.out.println();
		System.out.println("걸린시간 : " + (end - start) + "ns");
		s.close();
	}
}
//fkldfaewnkdkldkdafdmfklfklaf opajemlakmdlfka;l jfelkamdlkfa
//2380427