package day1.s3.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackEx2 {
	public String isPair(String msg) {
		String result = "OK";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			if (ch=='{' || ch=='[' || ch=='(') {
				stack.push(ch);
			} else if (ch == '}' || ch == ']' || ch == ')') {
				if (stack.isEmpty()) { // EmptyStackException 체크해도 됨
					result = "ERROR";
					break;
				}
				char ch2 = stack.pop();
				if (!(ch2 == getPair(ch))) {
					result = "ERROR";
					break;
				}
			}
		}
		if (!stack.isEmpty()) {
			result = "ERROR";
		}
		return result;
	}

	// 닫힌 괄호 입력시 열린 괄호의 짝이 무엇인지를 알려준다.
	public char getPair(char ch) {
		switch (ch) {
			case '}':	return '{';
			case ')':	return '(';
			case ']':	return '[';
		}
		return ' ';
	}

	public static void main(String[] args) {
		StackEx2 test = new StackEx2();
		Scanner s = new Scanner(System.in);
		String msg = s.nextLine();
		System.out.println("결과 : " + test.isPair(msg));
		s.close();
	}
}

/*

(a+b)-(c-d)

결과 : OK


{(a-b)+[d-b]}

결과 : OK


[a+b*(c-d)

결과 : ERROR


*/