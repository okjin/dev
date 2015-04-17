package day1.s5.assignment;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			String key = s.substring(i, i + 1);
			Integer value = map.get(key);
			if (value == null)
				map.put(key, 1);
			else
				map.put(key, value + 1);
		}
		TreeMap<String, Integer> treemap = new TreeMap<String, Integer>(map);
		StringBuilder sb = new StringBuilder();
		for (String key:treemap.keySet()) {
			int value = map.get(key);
			if (isPrime(value)) {
				sb.append(key);
			}
		}
		if (sb.length() == 0)
			System.out.println("NONE");
		else
			System.out.println(sb.toString());
		sc.close();
	}

	private static boolean isPrime(int x) {
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
AABAAB


출력 예:
B

*/

