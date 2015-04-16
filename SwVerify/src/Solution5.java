/*
 * 괄호 찾기
 * ()()(((())))()(())()
 */

import java.util.Scanner;

public class Solution5 {

	public static void main(String args[]){
		
		Scanner scanf = new Scanner(System.in);
		
		System.out.println("괄호들을 입력하세요. ");
		String inStr = scanf.next();
		System.out.println("입력된 괄호들 : " + inStr);
		
		System.out.println("몇번째 괄호의 짝을 찾으시나요? :  ");
		int inValue = scanf.nextInt();
		System.out.println(inValue + "번째 괄호와 짝괄호 찾는 문제입니다. "  );
		
		int[] inpair = new int[inStr.length()];
		
		
		for(int i=0;i<inStr.length();i++){
			inpair[i] = -1; //  초기화
			
		}
		
		
		// 3.시작이  ( 가 아닌  )로 시작하는 경우
		 if(!inStr.startsWith("(")){
			 System.out.println("0");
			return ;
		 }
		 
	//	 System.out.println("3번통과");
		 
		//1.괄호 갯수 체크해서  맞지 않으면  경우
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
		// System.out.println("1번통과");
		 
		int j=0;
		for(int i=0;i<cntRight;i++){
			int k= inStr.indexOf(")", j);
			
			j=k+1;
			
			for(int m=k;m>=0;m--){
				if((inStr.charAt(m-1) == '(') && (inpair[m-1] == -1)) {
					inpair[m-1] = k;
					inpair[k] = m-1;
					System.out.println((k+1) + " 와 짝은 " + (m) );
					break;
				}
			}
		}
		System.out.println(inValue + "번째 괄호와 짝괄호는 " + (inpair[inValue-1] + 1) + " 입니다."  );
		
		
	}
}
