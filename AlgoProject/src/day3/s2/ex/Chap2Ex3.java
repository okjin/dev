package day3.s2.ex;

public class Chap2Ex3 {

	public static void prefixMerge(Employee[] list1, Employee[] list2, 
													Employee[] result){
		int front1=0;
		int front2=0;

		for(int i=0; i<result.length; i++){
			int comparison=list1[front1].compareTo(list2[front2]);
			if(comparison<0){
				result[i]=list1[front1];
				front1++;
			}else if(comparison>0){
				result[i]=list2[front2];
				front2++;
			}else{
				result[i]=list1[front1];
				front1++;
				front2++;
			}
		}
	}

	public static void main(String[] args) {
		Employee[] a={new Employee("Arthur",4920),
				new Employee("Burton",3911),
				new Employee("Burton",4944),
				new Employee("Franz",1692),
				new Employee("Horton",9221),
				new Employee("Jones",5554),
				new Employee("Miller",9360),
				new Employee("Nguyen",4339)};
		Employee[] b={new Employee("Aaron",1729),
				new Employee("Baker",2921),
				new Employee("Burton",3911),
				new Employee("Dillard",6552),
				new Employee("Jones",5554),
				new Employee("Miller",9360),
				new Employee("Noble",3335)};
		Employee[] result=new Employee[6];
		
		prefixMerge(a,b,result);
		
		for(Employee c: result){
			System.out.println(c);		
		}
	}
	static class Employee implements Comparable<Employee>{
		private String name;
		private int id;
		public Employee() {
			super();
		}
		public Employee(String name, int id) {
			setName(name);
			setId(id);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Customer [name=" + name + ", id=" + id + "]";
		}
		@Override
		public int compareTo(Employee other) {
			int result=this.getName().compareTo(other.getName());
			if(result==0){
				result=this.getId()-other.getId();
			}
			return result;
		}
	}

}
