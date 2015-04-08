/*
 * 암호화된 텍스트 메시지의 복호화
 * 
 * 0 또는 1로 구성된 암호화된 텍스트 메시지가 주어진다. 이 메시지는 한 개의 ‘키값’과 한 개 이상의 ‘이진코드’로 구성된다. 
   이를 복호화하여 본래의 텍스트메시지를 확인하기 위해서는 반드시 ‘키값’을 알아야 한다. 입력되는 가장 첫 번째 3개의 수가 
   이진수인 ‘키값’ (k)을 의미한다.  ‘키값’이 결정된 이후에 입력되는 연속되는 8개의 수들이 한 개의 ‘이진코드’ (c)를 구성한다. 
   각각의 ‘이진코드’를 하나의 문자로 매핑하는 테이블은 다음과 같다.
   
 * D:\4.1.역량강화\SW검정_복호화.docx  
 * 
 * <출력>
   #1 APPLE
   #2 BANANA
 */

import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Solution2 {
	static char[]		Answer;
	
	public static void main(String[] args)  throws IOException  {
		// TODO Auto-generated method stub

		/*
		아래의 System.setIn 함수는 sample_input.txt 를 read only 형식으로 열어
		표준 입력 스트림으로 redirection 합니다.
		따라서, 키보드를 통한 표준 입력으로 입력 값을 전달하는 대신
		sample_input.txt 파일 내에 존재하는 데이터를 표준 입력 스트림으로 전달합니다.
		본 문제에 대한 소스코드를 테스트함에 있어, 원하는 입력 데이터를 sample_input.txt에 저장하여
		System.setIn 함수를 이용하면, 표준 입력 (키보드 입력) 대신 sample_input.txt 파일의 데이터가 전달됩니다.
		그러므로 테스트를 수행할 때에는 아래의 System.setIn 함수의 주석을 제거하여 사용할 수 있습니다.
		코드를 제출하실 때에는 반드시 System.setIn 함수를 지우거나 주석 처리 해야합니다.
		*/
		System.setIn(new FileInputStream("sample_input_2.txt"));

		/*
		표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
		Scanner sc = new Scanner(System.in);
		
		int		T;				// 테스트 케이스의 수
		int		i, l;
		String	tmp = null;
		String  inStr = null;
		String[] codeword = {"00000000","00000001","00000010",""};
		
		Answer = new char[200];
		
		/* 테스트 케이스의 수 T */
		T = sc.nextInt();
		sc.nextLine();
		
		/* 각 테스트 케이스에 대한 루프문 */
		for(i = 0; i < T; i++)
		{

			/*************************************************************************************/
			// 이 곳에 알고리즘을 구현합니다.
			// Input 배열에 저장된 입력 데이터에 대한 정답을 Answer 배열에 저장하는 것을 가정합니다.
			/*************************************************************************************/
			
			// Input 값 출력
			inStr = sc.nextLine();
			System.out.println(i + " : " + inStr);
			
			String key = inStr.substring(0, 3);
			String naStr = inStr.substring(3);
			
			System.out.println(i + " (key) : " + key);
			System.out.println(i + " (naStr) : " + naStr);

			System.out.println(i + " (codeword) : " + codeword[1]);
			
			do {
				if (naStr.length() < 8) break;
				
				String bf = naStr.substring(0, 8);
				
				
			} while (true);
			

			/* 출력부분 */
//			System.out.printf("#%d ", i+1);
//			tmp = new String(Answer,0,Answer.length);
//			System.out.printf("%s\n",tmp);
//			for(l = 0; l < 200 ; l++)
//				Answer[l] = 0;
		}
	}
	
	private char trans(String in) {
		
		
		return '0';
	}
	
}