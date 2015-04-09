/*
 * 단어찾기
 * 
 * a,b,c,d,e,f,g,h의 8개 영문자로 만들 수 있는 순열의 개수는 8! = 40320이다.
 * 이순열들을 사전 순서로 배열하고 이들의 순서를 적어보면 아래와 같다.
 * abcdefgh 1
 * abcdefhg 2
 * ..
 * hgfedcba 40320
 * 
 * <출력>
   6
   26521
   6034
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution3 {
	static char[] Answer;
	static char[] engChar = {'a','b','c','d','e','f','g','h'};
	static String[] str;
	
	
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
		System.setIn(new FileInputStream("sample_input_3.txt"));

		/*
		표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
		Scanner sc = new Scanner(System.in);
		
		int		T;				// 테스트 케이스의 수
		int		i, l;
		StringBuffer sb = new StringBuffer();
		String  inStr = null;

		Answer = new char[10];		// output
		str = new String[40320];	// 문자열
		
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
//			System.out.println(i + " : " + inStr);
			
			// 40320 문자열 배열에 저장
			for(int j=0; j < engChar.length; j++) {
				
			}

			

			/* 출력부분 */
//			System.out.printf("#%d ", i+1);
//			for(l = 0; l < Answer.length ; l++)
//				Answer[l] = 0;
		}
	}
	
	private static char trans(String key, String code) {
//		System.out.println("key : " + key + " trans : " + code);
		
		int k, c, l;
		k = Integer.valueOf(key, 2);
		c = Integer.valueOf(code, 2);
		
		if (c >= k) l = c - k;
		else l = c;
		
//		System.out.println("k : " + k + " c : " + c + " l : " + l);
		
		return l > codeword.length ? '?' : codeword[l];
	}
	
}