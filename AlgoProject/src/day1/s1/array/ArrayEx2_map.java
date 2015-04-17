package day1.s1.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArrayEx2_map {

	public static void main(String[] args) {
		long start=System.nanoTime();
		int[] jumsu = {90, 89, 76, 80, 45, 89, 89, 94, 55, 90 };

		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int each : jumsu) {
			boolean hasContains = map.containsKey(each);
			
			if (hasContains) {
				int count = map.get(each) + 1;
				map.put(each, count);
			}else {
				map.put(each, 1);
			}
		}		
		System.out.println(map);
		
		int highestCount = 0;
		int highestKey = 0;
		for (Integer key : map.keySet()) {
			int count = map.get(key);
			
			if (count > highestCount) {
				highestCount = count;
				highestKey = key;
			}
		}		
		long end=System.nanoTime();
		System.out.println(end-start);//849638
	}	
}
