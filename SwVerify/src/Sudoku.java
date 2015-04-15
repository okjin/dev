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
	static int Success = 0;
	static String[][] AnswerArr;
	static int WrongCnt = 0;
	
	static final int C = 9;	// ������ �迭 ũ�� 9 * 9
	
	
	static ArrayList<String> TmpList;
	static ArrayList<String> AnswerList;
	
	public static void main(String args[]) throws Exception
	{

		
		System.setIn(new FileInputStream("sudoku_2.txt"));

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
			
			AnswerArr = new String[N][2];	// Ʋ����ġ, ����

			char[][] map = new char[C][C];
			for(int i = 0 ; i < C ; i++) {
				for(int j = 0 ; j < C ; j++) {
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}

			//--------------------------------------
			
			// Input ���
			printInput(map);

			// Ʋ�� �� ã�� tmpList ����
			WrongCnt = 0;
			findWrongPosition(map);
			
			for (int i=0; i < TmpList.size(); i++) {
				System.out.println("TmpList : " + i + " " + TmpList.get(i).toString());
			}
			
			// Ʋ�� �� ��Ȯ�ϰ� �����ϰ� �´� �� ã��
			for (int i=0; i < TmpList.size(); i++) {
				int x, y;
				String[] tmp = TmpList.get(i).split(",");
				
				// �� ��ġ ����
				x = new Integer(tmp[0].charAt(0)+"");
				y = new Integer(tmp[0].charAt(1)+"");
				
				if (findWrongVer(x, y, map) > -1) {
					System.out.println("Got it !!!!" + x + "," + y);
					AnswerArr[i][0] = tmp[0].charAt(0)+" "+ tmp[0].charAt(1)+"";
					AnswerArr[i][1] = fixIt(x, y, map);
				}
				
				// �� ��ġ ����
				x = new Integer(tmp[1].charAt(0)+"");
				y = new Integer(tmp[1].charAt(1)+"");
				
				if (findWrongVer(x, y, map) > -1) {
					System.out.println("Got it !!!!" + x + "," + y);
					AnswerArr[i][0] = tmp[1].charAt(0)+" "+ tmp[1].charAt(1)+"";
					AnswerArr[i][1] = fixIt(x, y, map);
				}
			}
			
			// ǥ�����(ȭ��)���� ����� ����մϴ�.
			for(int i = 0 ; i < N ; i++) {
				System.out.println("#" + test_case + " : "+AnswerArr[i][0]+" "+AnswerArr[i][1]);
			}
		}
	}
	
	// ���� ã��
	private static String fixIt(int x, int y, char[][] a) {
		
		char[] tmp = {'x','x','x','x','x','x','x','x','x','x'};		// 10�� 'x' �� �ʱ�ȭ(�迭�� 0���ʹϱ�)
		
		for (int i=0; i < C; i++) {
			if (x != i) {
				tmp[new Integer(a[i][y]+"")] = 'o';
			}
		}
		System.out.println("fixIt : " + new String(tmp));
		
		for (int i=1; i < tmp.length; i++) {
			if (tmp[i] == 'x') return Integer.toString(i);
		}
		
		return null;
		
	}
	
	// Ʋ�� ��ġ ã��
	private static void findWrongPosition(char[][] a) {
		TmpList = new ArrayList<String>();
		
		// ���� �˻�
		for (int i=0; i < C; i++) {
			if (N == WrongCnt) break;
			
			for (int j=0; j < C; j++) {
				if (N == WrongCnt) break;
				findWrongHor(i, j, a);
			}
		}

	}
	
	// ���� �˻�(x �� ����, y�� �̵��ϸ鼭), �ߺ��� ��ġ ����
	private static int findWrongHor(int x, int y, char[][] a) {
		
		String tmp = "";
		
		for (int i = y+1; i < C; i++) {
			// �ڽ� ��ġ�� Skip, ���� ��ġ ���� ���������� ��
			if (a[x][y] == a[x][i]) {
				tmp = Integer.toString(x) + Integer.toString(y) + "," + Integer.toString(x) + Integer.toString(i);
				TmpList.add(tmp);	// tmpList �� �����Ҷ��� ��,�� ��ǥ ������� �߸��� ������ �� (Ʋ�� ��ġ ã�⸦ ���ؼ� Ȯ��)
				WrongCnt ++;
			}
		}
		
		return 0;
	}
	
	// ���� �˻�(y �� ����, x�� �̵��ϸ鼭) ������(���η� �˻��ؼ� �ߺ��Ǹ� �ش� ��ġ�� �߸��� ��)
	private static int findWrongVer(int x, int y, char[][] a) {
		
		for (int i=0; i < C; i++) {
			// �ڽ� ��ġ�� Skip, ���� ��ġ ���� ���������� ��
			if (x != i && a[x][y] == a[i][y]) {
				return i;
			}
		}
		
		return -1;
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

