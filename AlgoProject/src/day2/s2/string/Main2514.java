package day2.s2.string;


import java.util.Scanner;

public class Main2514 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String ss = s.next();
		int start = 0;
		int koi = 0;
		int ioi = 0;
		while (true) {
			if (start >= ss.length())
				break;
			if (ss.indexOf("KOI", start) == -1)
				break;
			start = ss.indexOf("KOI", start) + 3;
			koi++;
		}
		start = 0;
		while (true) {
			if (start >= ss.length())
				break;
			if (ss.indexOf("IOI", start) == -1)
				break;
			start = ss.indexOf("IOI", start) + 2;
			ioi++;
		}
		System.out.println(koi);
		System.out.println(ioi);
		s.close();
	}
}
