package day4.s4.string;
//작명하기
import java.util.Scanner;

public class Main1332_1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String  msg=s.nextLine();
		s.close();
		
		String m1=null;
		String m2=null;
		int len=msg.length();
		for(int i=1; i<len; i++){
			//m1=msg.substring(0,i);
			m1=msg.substring(len-i);
			if(msg.startsWith(m1)){
				System.out.print(i+" ");
			}
		}
		System.out.println(len);
	}
}
