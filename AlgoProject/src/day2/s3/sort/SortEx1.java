package day2.s3.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortEx1 {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();		
		list.add( "박용우" );
		list.add( "박건영");
		list.add( "김도훈" );
		list.add( "정세은" );
		list.add( "이시연" );
		System.out.println("Sort 전 : "+list);
		
		Collections.sort(list);
		System.out.println("Sort 후: "+list);
		
		String cname="배하나";
		for(int i=0; i<list.size(); i++){
			if(cname.compareTo(list.get(i))<0){
				list.add(i, cname);
				break;
			}
		}
		System.out.println("배하나 삽입 : "+list);
	}
}
