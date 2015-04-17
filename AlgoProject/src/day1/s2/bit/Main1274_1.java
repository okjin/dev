package day1.s2.bit;

import java.util.Scanner;

public class Main1274_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String bin = s.next();

		char[] ch = bin.toCharArray();
		int len = ch.length - 1;

		int flag = 1;
		if (ch[0] == '1') {
			flag = -1;
			if (ch[len] == '1') {
				ch[len] = '0';
			} else {
				ch[len] = '1';
				for (int i = len - 1; i >= 0; i--) {
					if (ch[i] == '1') {
						ch[i] = '0';
						break;
					} else {
						ch[i] = '1';
					}
				}
			}
			for (int i = 0; i < ch.length; i++) {
				ch[i] = (ch[i] == '0') ? '1' : '0';
			}
		}
		int su = 0;
		for (int i = 0; i < ch.length; i++) {
			su = su + (int) Math.pow(2, ch.length - i - 1) * (ch[i] - '0');
		}
		System.out.println(su * flag);
		s.close();
	}
}
/*

00000101

5


10011000

-104

 */
