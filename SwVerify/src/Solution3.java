/*
 * �ܾ�ã��
 * 
 * a,b,c,d,e,f,g,h�� 8�� �����ڷ� ���� �� �ִ� ������ ������ 8! = 40320�̴�.
 * �̼������� ���� ������ �迭�ϰ� �̵��� ������ ����� �Ʒ��� ����.
 * abcdefgh 1
 * abcdefhg 2
 * ..
 * hgfedcba 40320
 * 
 * <���>
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
		�Ʒ��� System.setIn �Լ��� sample_input.txt �� read only �������� ����
		ǥ�� �Է� ��Ʈ������ redirection �մϴ�.
		����, Ű���带 ���� ǥ�� �Է����� �Է� ���� �����ϴ� ���
		sample_input.txt ���� ���� �����ϴ� �����͸� ǥ�� �Է� ��Ʈ������ �����մϴ�.
		�� ������ ���� �ҽ��ڵ带 �׽�Ʈ�Կ� �־�, ���ϴ� �Է� �����͸� sample_input.txt�� �����Ͽ�
		System.setIn �Լ��� �̿��ϸ�, ǥ�� �Է� (Ű���� �Է�) ��� sample_input.txt ������ �����Ͱ� ���޵˴ϴ�.
		�׷��Ƿ� �׽�Ʈ�� ������ ������ �Ʒ��� System.setIn �Լ��� �ּ��� �����Ͽ� ����� �� �ֽ��ϴ�.
		�ڵ带 �����Ͻ� ������ �ݵ�� System.setIn �Լ��� ����ų� �ּ� ó�� �ؾ��մϴ�.
		*/
		System.setIn(new FileInputStream("sample_input_3.txt"));

		/*
		ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		*/
		Scanner sc = new Scanner(System.in);
		
		int		T;				// �׽�Ʈ ���̽��� ��
		int		i, l;
		StringBuffer sb = new StringBuffer();
		String  inStr = null;

		Answer = new char[10];		// output
		str = new String[40320];	// ���ڿ�
		
		/* �׽�Ʈ ���̽��� �� T */
		T = sc.nextInt();
		sc.nextLine();
		
		/* �� �׽�Ʈ ���̽��� ���� ������ */
		for(i = 0; i < T; i++)
		{

			/*************************************************************************************/
			// �� ���� �˰����� �����մϴ�.
			// Input �迭�� ����� �Է� �����Ϳ� ���� ������ Answer �迭�� �����ϴ� ���� �����մϴ�.
			/*************************************************************************************/
			
			// Input �� ���
			inStr = sc.nextLine();
//			System.out.println(i + " : " + inStr);
			
			// 40320 ���ڿ� �迭�� ����
			for(int j=0; j < engChar.length; j++) {
				
			}

			

			/* ��ºκ� */
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