package day3.s1.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SearchCollectionApiTest {

	public static void main(String[] args) {
		ArrayList<Employee> list=new ArrayList<Employee>();		
		list.add( new Employee("1301","ȫ�浿",3700) );
		list.add( new Employee("1008","���ϳ�",6700) );
		list.add( new Employee("0901","�ҳ���",7700) );
		list.add( new Employee("1205","�ѾƸ�",4700) );
		list.add( new Employee("1111","��ö��",5700) );

		int pos1=Collections.binarySearch(list,new Employee("0901","�ҳ���",7700));
		System.out.println("Before : "+ list);
		System.out.println("Before : "+ pos1);
		
		Collections.sort(list);
		
		int pos2=Collections.binarySearch(list,new Employee("0901","�ҳ���",7700));		
		System.out.println("After : "+ list);
		System.out.println("After : "+ pos2);

	}
}
