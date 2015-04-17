package day1.s3.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main1102 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			String c = s.next();
			switch (c) {
				case "i":
					int a = s.nextInt();
					st.push(a);
					break;
				case "c":
					System.out.println(st.size());
					break;
				case "o":
					if (st.isEmpty()) {
						System.out.println("empty");
					} else {
						System.out.println(st.pop());
					}
			}
			s.close();
		}
	}
}
