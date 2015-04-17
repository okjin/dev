package day2.s3.sort;

public class Employee implements Comparable<Employee>{
	/**사원 번호 */
	private String empno;	
	/**사원 이름 */
	private String ename;
	/**사원 급여 정보*/ 
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
//			=> 사원 번호만 같으면 같은 사원으로 처리 
			if(empno.equals(emp.empno)) return true;
		}
		return false;
	}
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
			//사원 번호를 기준으로 정렬하기 위해 사원번호를 비교한다. 
			return empno.compareTo(emp.getEmpno());
		}
		return 0;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [사번 = ");
		builder.append(getEmpno());
		builder.append(", 이름 = ");
		builder.append(getEname());
		builder.append(", 연봉 = ");
		builder.append(getSalary());
		builder.append("]");
		return builder.toString();
	}
}

