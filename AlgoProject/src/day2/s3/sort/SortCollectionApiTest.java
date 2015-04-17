package day2.s3.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortCollectionApiTest {
	public static void main(String[] args) {
		ArrayList<Employee> list=new ArrayList<Employee>();		
		list.add( new Employee("1301","È«±æµ¿",3700) );
		list.add( new Employee("1008","ÀÌÇÏ³ª",6700) );
		list.add( new Employee("0901","¼Ò³ª¹«",7700) );
		list.add( new Employee("1205","ÇÑ¾Æ¸§",4700) );
		list.add( new Employee("1111","±èÃ¶¼ö",5700) );

		Collections.sort(list);
		for(Employee  e: list){
			System.out.println(e);
		}
		System.out.println("============ Salary Sort ============="); 
		Collections.sort(list, new EmployeeComparator("salary"));
		for(Employee  e: list){
			System.out.println(e);
		}
	}
}

