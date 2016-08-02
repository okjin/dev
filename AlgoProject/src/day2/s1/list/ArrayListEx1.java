package day2.s1.list;

import java.util.ArrayList;

public class ArrayListEx1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(23);
		list.add(36);
		list.add(47);
		list.add(49);
		list.add(50);		
		System.out.println(list);
		
		list.add(0, 5);
		System.out.println(list);
		
		list.remove(3);
		System.out.println(list);
		
		list.remove(new Integer(12));
		System.out.println(list);
		
		System.out.println("갯수: "+list.size());
		
		System.out.println("12포함 :"+list.contains(49));
		
		System.out.println("마지막 값 50? "+ (list.get(list.size()-1)==50));
		
		Integer[]  arr=new Integer[list.size()];
		list.toArray(arr);
		for(int k: arr){
			System.out.print(k+" ");
			
			//수정
		}
	}

}
