package day2.s3.sort;

import java.util.Arrays;

public class SortObjectApiTest {

	public static void main(String[] args) {
		Employee[]  emps={ 	new Employee("1301","홍길동",3700),
							new Employee("1008","이하나",6700),
							new Employee("0901","소나무",7700),
							new Employee("1205","한아름",4700),
							new Employee("1111","김철수",5700),
						  };
		Arrays.sort(emps);
		for(Employee  e: emps){
			System.out.println(e);
		}
	}
}
