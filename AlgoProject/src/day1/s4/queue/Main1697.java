package day1.s4.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1697 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<String> st=new ArrayList<String>();
		for(int i=0; i<n; i++){
			String c=s.next();
			switch(c){
			case "i":
				String v=s.next();
				st.add(v);
				break;
			case "o":
				if(st.isEmpty()){
					System.out.println("empty");
				}else{
					System.out.println(st.remove(0));
				}
				break;
			case "c":
				System.out.println(st.size());
			}
		}
		s.close();
	}
}
/*

입력 예:
7
i 7
i 5
c
o
o
o
c


출력 예:
2
7
5
empty
0

*/