import java.util.Scanner;


public class printBinary {

	public static void main(String[] args) throws Exception 
	{
		int in; 		// 입력값
		int mok = 0;	// 몫 
		int nam = 0;	// 나머지  --> 이진값 저장
		
		StringBuffer sb = new StringBuffer();
		
		Scanner sc = new Scanner(System.in);
		in = sc.nextInt();
		
		System.out.println("이진수(검증용) : " + Integer.toBinaryString(in));
		
		do {
			
			mok = in / 2;
			nam = in % 2;
			sb.append(nam);
			
			in = mok;
			if (in == 0 ) break;
			
		} while(true);
		
		
		System.out.println("이진수 : " + sb.reverse().toString());


	}
	
}