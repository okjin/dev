package day2.s4.assignment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Chap1Ex4_2 {
	public static void main(String[] args) {
		HashMap<Integer, ArrayList<String>> map=new HashMap<Integer, ArrayList<String>>();
		Scanner s=new Scanner(System.in);
		while(true){
			String name=s.nextLine();
			int len=name.length();
			if(len == 0) break;
			ArrayList<String> list=null;
			if(map.containsKey(len)){
				list=map.get(len);
			}else{
				list=new ArrayList<String>();
			}
			list.add(name);
			map.put(len, list);
		}
		for(int key : map.keySet()){
			System.out.println("Words of length ("+key+") ===>"+map.get(key) );
		}
		s.close();
	}
}
