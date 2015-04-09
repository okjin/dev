/*
 * ��ȣȭ�� �ؽ�Ʈ �޽����� ��ȣȭ
 * 
 * 0 �Ǵ� 1�� ������ ��ȣȭ�� �ؽ�Ʈ �޽����� �־�����. �� �޽����� �� ���� ��Ű������ �� �� �̻��� �������ڵ塯�� �����ȴ�. 
   �̸� ��ȣȭ�Ͽ� ������ �ؽ�Ʈ�޽����� Ȯ���ϱ� ���ؼ��� �ݵ�� ��Ű������ �˾ƾ� �Ѵ�. �ԷµǴ� ���� ù ��° 3���� ���� 
   �������� ��Ű���� (k)�� �ǹ��Ѵ�.  ��Ű������ ������ ���Ŀ� �ԷµǴ� ���ӵǴ� 8���� ������ �� ���� �������ڵ塯 (c)�� �����Ѵ�. 
   ������ �������ڵ塯�� �ϳ��� ���ڷ� �����ϴ� ���̺��� ������ ����.
   
 * D:\4.1.������ȭ\SW����_��ȣȭ.docx  
 * 
 * <���>
   #1 APPLE
   #2 BANANA
 */

import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Solution2 {
	static char[] Answer;
	static char[] codeword = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
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
		System.setIn(new FileInputStream("sample_input_2.txt"));

		/*
		ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		*/
		Scanner sc = new Scanner(System.in);
		
		int		T;				// �׽�Ʈ ���̽��� ��
		int		i, l;
		String	tmp = null;
		String  inStr = null;

		Answer = new char[200];
		
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
			
			String key = inStr.substring(0, 3);
			String naStr = inStr.substring(3);
			
//			System.out.println(i + " (key) : " + key);
//			System.out.println(i + " (naStr) : " + naStr);

			int ai = 0;
			do {
				if (naStr.length() < 8) break;
				
				String bf = naStr.substring(0, 8);
				Answer[ai++] = trans(key, bf);
				
				naStr = naStr.substring(8);
				
			} while (true);
			

			/* ��ºκ� */
			System.out.printf("#%d ", i+1);
			tmp = new String(Answer,0,Answer.length);
			System.out.printf("%s\n",tmp);
			for(l = 0; l < 200 ; l++)
				Answer[l] = 0;
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