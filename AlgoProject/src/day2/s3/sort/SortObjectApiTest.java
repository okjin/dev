package day2.s3.sort;

import java.util.Arrays;

public class SortObjectApiTest {

	public static void main(String[] args) {
		Employee[]  emps={ 	new Employee("1301","ȫ�浿",3700),
							new Employee("1008","���ϳ�",6700),
							new Employee("0901","�ҳ���",7700),
							new Employee("1205","�ѾƸ�",4700),
							new Employee("1111","��ö��",5700),
						  };
		Arrays.sort(emps);
		for(Employee  e: emps){
			System.out.println(e);
		}
	}
}
