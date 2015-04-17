package day2.s1.list;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListEx2 {
	public static void main(String[] args) {
		ArrayList<Integer>  list = new ArrayList<Integer>();
		list.add(90);
		list.add(89);
		list.add(76);
		list.add(80);
		list.add(45);
		list.add(89);
		list.add(89);
		list.add(94);
		list.add(44);
		list.add(90);
		
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int jum : list){
			int value=0;
			if(map.containsKey(jum)){
				value=map.get(jum);
			}
			map.put(jum, ++value);
		}
		for(int key: map.keySet()){
			System.out.println(key+" - "+map.get(key)+" 번");
		}
		
		int max=0;
		int jum=0;
		for(int key: map.keySet()){
			if(map.get(key)>max){
				max=map.get(key);
				jum=key;
			}
		}
		System.out.println("가장 많이 입력된 수:"+jum);
	}
}
