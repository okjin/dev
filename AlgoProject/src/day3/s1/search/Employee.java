package day3.s1.search;

public class Employee implements Comparable<Employee>{
	/**��� ��ȣ */
	private String empno;	
	/**��� �̸� */
	private String ename;
	/**��� �޿� ����*/ 
	private int salary;
	
	public Employee(){}
	public Employee(String empno) {
		this.empno = empno;
	}
	public Employee( String empno, String ename, int salary) {
		this.empno = empno;		
		this.ename = ename;
		this.salary = salary;
	}
	public boolean equals(Object obj) {
		if (obj !=null && obj instanceof Employee) {
			Employee emp = (Employee) obj;
//			=> ��� ��ȣ�� ������ ���� ������� ó�� 
			if(empno.equals(emp.empno)) return true;
		}
		return false;
	}
	/**
	 * hashCode() : ��ü�� hashCode�� �����Ѵ� 
	 * hashCode()�� �������̵� 
	 * => ��ü�� hashCode �ڵ�� ������ ���� 
	 *    hashCode()�� ȣ���� ��� ���� ������ ���� 
	 *   ���� : ���� ��ü�� �ٸ����� ������ ���ٸ� ���� hashcode�� �ο�    
	 */
	@Override
	public int hashCode() {
		return empno.hashCode() ^  ename.hashCode() ^  salary ;
	}
	public String getEname() 			{return ename;	}
	public void setEname(String ename) 	{this.ename = ename;}
	public String getEmpno() 			{return empno;	}
	public void setEmpno(String empno) 	{this.empno = empno;}
	public int getSalary() 				{return salary;	}
	public void setSalary(int salary)	{this.salary = salary;}
	
	@Override
	public int compareTo(Employee o) {
		if (o!= null ) {
			Employee emp = (Employee) o;
			//��� ��ȣ�� �������� �����ϱ� ���� �����ȣ�� ���Ѵ�. 
			return empno.compareTo(emp.getEmpno());
		}
		return 0;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [��� = ");
		builder.append(getEmpno());
		builder.append(", �̸� = ");
		builder.append(getEname());
		builder.append(", ���� = ");
		builder.append(getSalary());
		builder.append("]");
		return builder.toString();
	}

}

