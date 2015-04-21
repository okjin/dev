/*
 * ���� �䳢���
 * 
 */

import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution1
{
	static int N;
	static int AnswerN;
	
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("sample_input_1.txt"));

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

			N = sc.nextInt();

			char[][] map = new char[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
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
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if (map[i][j] == 'A') {
						if(i-1 >= 0 && map[i-1][j] == 'H') map[i-1][j] = 'X';
						if(i+1 < N && map[i+1][j] == 'H') map[i+1][j] = 'X';
						if(j-1 >= 0 && map[i][j-1] == 'H') map[i][j-1] = 'X';
						if(j+1 < N && map[i][j+1] == 'H') map[i][j+1] = 'X';
					}
					if (map[i][j] == 'B') {
						if(i-1 >= 0 && map[i-1][j] == 'H') map[i-1][j] = 'X';
						if(i-2 >= 0 && map[i-2][j] == 'H') map[i-2][j] = 'X';
						if(i+1 < N && map[i+1][j] == 'H') map[i+1][j] = 'X';
						if(i+2 < N && map[i+2][j] == 'H') map[i+2][j] = 'X';
						if(j-1 >= 0 && map[i][j-1] == 'H') map[i][j-1] = 'X';
						if(j-2 >= 0 && map[i][j-2] == 'H') map[i][j-2] = 'X';
						if(j+1 < N && map[i][j+1] == 'H') map[i][j+1] = 'X';
						if(j+2 < N && map[i][j+2] == 'H') map[i][j+2] = 'X';
					}
					if (map[i][j] == 'C') {
						if(i-1 >= 0 && map[i-1][j] == 'H') map[i-1][j] = 'X';
						if(i-2 >= 0 && map[i-2][j] == 'H') map[i-2][j] = 'X';
						if(i-3 >= 0 && map[i-3][j] == 'H') map[i-3][j] = 'X';
						if(i+1 < N && map[i+1][j] == 'H') map[i+1][j] = 'X';
						if(i+2 < N && map[i+2][j] == 'H') map[i+2][j] = 'X';
						if(i+3 < N && map[i+3][j] == 'H') map[i+3][j] = 'X';
						if(j-1 >= 0 && map[i][j-1] == 'H') map[i][j-1] = 'X';
						if(j-2 >= 0 && map[i][j-2] == 'H') map[i][j-2] = 'X';
						if(j-3 >= 0 && map[i][j-3] == 'H') map[i][j-3] = 'X';
						if(j+1 < N && map[i][j+1] == 'H') map[i][j+1] = 'X';
						if(j+2 < N && map[i][j+2] == 'H') map[i][j+2] = 'X';
						if(j+3 < N && map[i][j+3] == 'H') map[i][j+3] = 'X';
					}
				}
			}
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					System.out.print(map[i][j]);
					if (map[i][j] == 'H') ++AnswerN;
				}
				System.out.print('\n');
			}
			
			// ǥ�����(ȭ��)���� ����� ����մϴ�.

			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
}

