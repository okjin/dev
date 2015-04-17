package day3.s2.ex;

import java.util.Arrays;

public class Chap2Ex1 {
	public static void main(String[] args) {
		Student[] st={new Student(1,"kim young",99,88),
				new Student(2,"park nim",100,100),
				new Student(3,"sin jin",89,95),
				new Student(4,"park jin",88,99)};
		
		for(Student s: st){
			s.setTotal(s.getEng()+s.getMath());
			System.out.println(s);
		}
		System.out.println("=============================== 성적 처리 후 ==================================");
		
		Arrays.sort(st);
		
		for(int i=0; i< st.length; i++){
			//만약 같은 총점이 있다면
			if( i != 0 && st[i].getTotal()==st[i-1].getTotal()){
				//총점이 같은 다른 총점의 등수를 꺼내어  등수를 넣는다.
				st[i].setRank(st[i-1].getRank());
			}else{
				st[i].setRank(i+1);
			}
			System.out.println(st[i]);
		}
	}
	static class Student implements Comparable<Student>{
			private int num;
			private String name;
			private int eng;
			private int math;
			private int total;
			private int rank;
			
			public Student() {
				super();
			}
			public Student(int num, String name, int eng, int math) {
				super();
				this.num = num;
				this.name = name;
				this.eng = eng;
				this.math = math;
			}
			public int getNum() {
				return num;
			}
			public void setNum(int num) {
				this.num = num;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getEng() {
				return eng;
			}
			public void setEng(int eng) {
				this.eng = eng;
			}
			public int getMath() {
				return math;
			}
			public void setMath(int math) {
				this.math = math;
			}
			public int getTotal() {
				return total;
			}
			public void setTotal(int total) {
				this.total = total;
			}
			public int getRank() {
				return rank;
			}
			public void setRank(int rank) {
				this.rank = rank;
			}
			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("Student [num=");
				builder.append(num);
				builder.append(", name=");
				builder.append(name);
				builder.append(", eng=");
				builder.append(eng);
				builder.append(", math=");
				builder.append(math);
				builder.append(", total=");
				builder.append(total);
				builder.append(", rank=");
				builder.append(rank);
				builder.append("]");
				return builder.toString();
			}
			@Override
			public int compareTo(Student o) {
				return o.total-total;
			}	
		}

}
