package day2.s3.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortEx1 {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();		
		list.add( "�ڿ��" );
		list.add( "�ڰǿ�");
		list.add( "�赵��" );
		list.add( "������" );
		list.add( "�̽ÿ�" );
		System.out.println("Sort �� : "+list);
		
		Collections.sort(list);
		System.out.println("Sort ��: "+list);
		
		String cname="���ϳ�";
		for(int i=0; i<list.size(); i++){
			if(cname.compareTo(list.get(i))<0){
				list.add(i, cname);
				break;
			}
		}
		System.out.println("���ϳ� ���� : "+list);
	}
}
