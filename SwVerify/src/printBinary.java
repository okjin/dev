import java.util.Scanner;


public class printBinary {

	public static void main(String[] args) throws Exception 
	{
		int in; 		// �Է°�
		int mok = 0;	// �� 
		int nam = 0;	// ������  --> ������ ����
		
		StringBuffer sb = new StringBuffer();
		
		Scanner sc = new Scanner(System.in);
		in = sc.nextInt();
		
		System.out.println("������(������) : " + Integer.toBinaryString(in));
		
		do {
			
			mok = in / 2;
			nam = in % 2;
			sb.append(nam);
			
			in = mok;
			if (in == 0 ) break;
			
		} while(true);
		
		
		System.out.println("������ : " + sb.reverse().toString());


	}
	
}