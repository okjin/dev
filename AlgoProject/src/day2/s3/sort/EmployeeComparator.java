package day2.s3.sort;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	String orderBy;
	public EmployeeComparator(String orderBy){
		this.orderBy=orderBy;
	}
	@Override
	public int compare(Employee o1, Employee o2) {
		if(orderBy.equalsIgnoreCase("name")){
			return o1.getEname().compareTo(o2.getEname());
		}else if(orderBy.equalsIgnoreCase("salary")){
			return o1.getSalary()-o2.getSalary();
		}
		return o1.getEmpno().compareTo(o2.getEmpno());
	}	
}
