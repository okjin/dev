package day3.s2.ex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Chap2Ex2 {	
	public static void main(String[] args) {
		int[] co=new int[10];
		
		Scanner s=new Scanner(System.in);
		String msg=s.nextLine();
		//�󵵼� ����
		int len=msg.length();
		for(int i=0; i< len; i++){
			co[msg.charAt(i)-'0']++;
		}
		//System.out.println(Arrays.toString(co));
		//�ְ� 3�� ���ϱ�
		int max=0;
		int pos=-1;
		for(int i=0; i<3; i++){
			for(int j=0; j<10; j++){ 
				if(max<co[j]){
					max=co[j];
					pos=j;
				}
			}	
			System.out.print(pos);
			co[pos]=0;
			pos=-1;
			max=0;
		}
		System.out.println();
		s.close();
	}
}
