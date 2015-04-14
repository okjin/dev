/*
 * ������ Ʋ�� ��ġ,�� ã��
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Sudoku
{
	static int N;
	static int AnswerN;
	static int Success = 0;
	static String[][] AnswerArr;
	static int WrongCnt = 0;
	
	static final int C = 9;	// ������ �迭 ũ�� 9 * 9
	
	
	static ArrayList<String> TmpList;
	static ArrayList<String> AnswerList;
	
	public static void main(String args[]) throws Exception
	{

		
		System.setIn(new FileInputStream("sudoku_1.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			/*
				�� �׽�Ʈ ���̽��� ǥ�� �Է¿��� �о�ɴϴ�.
			*/

			N = sc.nextInt();	// Ʋ�� ����
			
//			AnswerArr = new String[N][2];	// Ʋ����ġ, ����

			char[][] map = new char[C][C];
			for(int i = 0 ; i < C ; i++) {
				for(int j = 0 ; j < C ; j++) {
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 �� �κп� �������� �˰��� ������ ���ϴ�.
			 �������� ������ AnswerN�� ����Ǵ� ���� �����Ͽ����ϴ�.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			AnswerN = 0;
			// Input ���
			printInput(map);

			// Ʋ�� ��ġ ã��
			findWrongPosition(map);
			
			for (int i=0; i < TmpList.size(); i++) {
				System.out.println("AnsewerL : " + i + " " + TmpList.get(i).toString());
			}
			
			// ǥ�����(ȭ��)���� ����� ����մϴ�.
//			for(int i = 0 ; i < N ; i++) {
//				
//				System.out.println("#"+test_case+" : "+AnswerArr[i][0]+" "+AnswerArr[i][1]);
//			}
		}
	}
	
	// Ʋ�� ��ġ ã��
	private static void findWrongPosition(char[][] a) {
		TmpList = new ArrayList<String>();
		
		for (int i=0; i < C; i++) {
			if (N == WrongCnt) break;
			
			for (int j=0; j < C; j++) {
				if (N == WrongCnt) break;
				findWrongByChar(i, j, a);
			}
		}
	}
	
	// ���� ��ġ���� ����, ���� �˻��ؼ� �ߺ��� ��ġ ����
	private static int findWrongByChar(int x, int y, char[][] a) {
		
		String tmp = "";
		
		if (N == WrongCnt) return 1;
		
		// ���� �˻�
		for (int i=0; i < C; i++) {
			// �ڽ� ��ġ�� Skip, �ڽ� ��ġ ���� ���������� ��
			if (i != y && a[x][y] == a[x][i]) {
				tmp = Integer.toString(x) + Integer.toString(y) + Integer.toString(x) + Integer.toString(i);
				TmpList.add(tmp);
				WrongCnt ++;
				break;
			}
		}
		
		// ���� �˻� 
		for (int i=0; i < C; i++) {
			// �ڽ� ��ġ�� Skip, �ڽ� ��ġ ���� ���������� ��
			if (i != x && a[x][y] == a[i][y]) {
				tmp = Integer.toString(x) + Integer.toString(y) + Integer.toString(i) + Integer.toString(y);
				TmpList.add(tmp);
				WrongCnt ++;
			}
		}
	
		return 0;
	}
	



	private static void printInput(char[][] in) {
		for(int i = 0 ; i < C ; i++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print(in[i][j]);
			}
			System.out.print('\n');
		}
	}

}

