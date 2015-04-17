package day1.s1.array;

import java.util.TreeMap;

public class ArrayEx2 {
	public static void main(String[] args) {
		int[] jumsu = { 90, 89, 76, 80, 45, 89, 89, 94, 55, 90 };

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int jum : jumsu) {
			int value = 0;
			if (map.containsKey(jum)) {
				value = map.get(jum);
			}
			map.put(jum, ++value);
		}
		for (int key : map.keySet()) {
			System.out.println("점수: " + key + " - " + map.get(key) + " 명");
		}
		int max = 0;
		int jum = 0;
		for (int key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				jum = key;
			}
		}
		
		System.out.println("가장 많은 받은 점수 : " + jum);
	}
}
