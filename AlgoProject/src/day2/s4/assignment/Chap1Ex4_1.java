package day2.s4.assignment;


import java.util.HashMap;
import java.util.Scanner;

public class Chap1Ex4_1 {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		Scanner s=new Scanner(System.in);
		while(true){
			String name=s.nextLine();
			int len=name.length();
			if(len == 0) break;
			int value=0;
			if(map.containsKey(len)){
				value=map.get(len);
			}
			map.put(len, ++value);
		}
		for(int key : map.keySet()){
			System.out.println("Words of length ("+key+") ===>"+map.get(key) );
		}
		s.close();
	}
}
