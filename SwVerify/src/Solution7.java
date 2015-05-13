/*
 * ������
 * 
 */

import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution7
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
		System.setIn(new FileInputStream("sample_input_72.txt"));

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
					System.out.print(map[i][j]);
				}
				System.out.print('\n');
			}
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 �� �κп� �������� �˰��� ������ ���ϴ�.
			 �������� ������ AnswerN�� ����Ǵ� ���� �����Ͽ����ϴ�.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			AnswerN = 0;
			boolean isFox = false;
			int x = 0;
			int y = 0;
			for(int i = 0 ; i < N ; i++) {
				if (isFox) break;
				for(int j = 0 ; j < N ; j++) {
					if (map[i][j] == 'F') {
						x = i;
						y = j;
						isFox = true;
						break;
					}
				}
			}
			
			//����, ����
			for(int i = 0; i < N; i++) {
				if (map[i][y] == 'R') map[i][y] = 'X';
				if (map[x][i] == 'R') map[x][i] = 'X';
			}
			
			
			for(int i = 1; i < N; i++) {
				//���->����
				if (y+i < N && x-i >= 0 && map[x-i][y+i] == 'R') {
					map[x-i][y+i] = 'X';
				}
				if (x+i < N && y-i >= 0 && map[x+i][y-i] == 'R' ) {
					map[x+i][y-i] = 'X';
				}
				//�»�->����
				if (y-i >= 0  && x-i >= 0 && map[x-i][y-i] == 'R') {
					map[x-i][y-i] = 'X';
				}
				if (x+i < N && y+i < N && map[x+i][y+i] == 'R' ) {
					map[x+i][y+i] = 'X';
				}
			}
			
			System.out.println("AnserN!!!");
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					System.out.print(map[i][j]);
					if (map[i][j] == 'X') ++AnswerN;
				}
				System.out.print('\n');
			}
			
			// ǥ�����(ȭ��)���� ����� ����մϴ�.

			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
	
	
}

