/*
 * ��ȣ ã��
 * ()()(((())))()(())()
 */

import java.util.Scanner;

public class Solution5 {

	public static void main(String args[]){
		
		Scanner scanf = new Scanner(System.in);
		
		System.out.println("��ȣ���� �Է��ϼ���. ");
		String inStr = scanf.next();
		System.out.println("�Էµ� ��ȣ�� : " + inStr);
		
		System.out.println("���° ��ȣ�� ¦�� ã���ó���? :  ");
		int inValue = scanf.nextInt();
		System.out.println(inValue + "��° ��ȣ�� ¦��ȣ ã�� �����Դϴ�. "  );
		
		int[] inpair = new int[inStr.length()];
		
		
		for(int i=0;i<inStr.length();i++){
			inpair[i] = -1; //  �ʱ�ȭ
			
		}
		
		
		// 3.������  ( �� �ƴ�  )�� �����ϴ� ���
		 if(!inStr.startsWith("(")){
			 System.out.println("0");
			return ;
		 }
		 
	//	 System.out.println("3�����");
		 
		//1.��ȣ ���� üũ�ؼ�  ���� ������  ���
		int cntLeft = 0;
		int cntRight = 0;
		
			 
		for(int i=0;i<inStr.length();i++){
			if(inStr.charAt(i) =='('){
				cntLeft = cntLeft + 1;
				
			}
			else if(inStr.charAt(i) ==')'){
				cntRight = cntRight + 1;
				
			}
			else{
				System.out.println("0");
				return ;		
			}
		}
		
		if(cntLeft != cntRight){
			System.out.println("0");
			return ;			
		}
		// System.out.println("1�����");
		 
		int j=0;
		for(int i=0;i<cntRight;i++){
			int k= inStr.indexOf(")", j);
			
			j=k+1;
			
			for(int m=k;m>=0;m--){
				if((inStr.charAt(m-1) == '(') && (inpair[m-1] == -1)) {
					inpair[m-1] = k;
					inpair[k] = m-1;
					System.out.println((k+1) + " �� ¦�� " + (m) );
					break;
				}
			}
		}
		System.out.println(inValue + "��° ��ȣ�� ¦��ȣ�� " + (inpair[inValue-1] + 1) + " �Դϴ�."  );
		
		
	}
}
