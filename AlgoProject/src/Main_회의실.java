import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_È¸ÀÇ½Ç {
	public static class Meeting implements Comparable<Meeting>{
		public int num;
		public int start;
		public int end;
		
		public Meeting(int num, int start, int end) {
			super();
			this.num = num;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return end - o.end;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] meetings = new Meeting[N];
		
		for(int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(meetings);
		
		List<Meeting> enable = new ArrayList<Meeting>();
		Meeting current = meetings[0];  
		enable.add(current);
		for(int i = 1; i < N; i++) {
			if(current.end <= meetings[i].start) {
				enable.add(meetings[i]);
				current = meetings[i];
			}
		}
		System.out.println(enable.size());
		
		for(Meeting m : enable) {
			System.out.print(m.num + " ");
		}
		
		sc.close();
	}
}
