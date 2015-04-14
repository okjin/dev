/*
 * �̷� ��ã��
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution4
{
	static int N;
	static int AnswerN;
	static int Success = 0;
	static int[][] Root;
	
	static ArrayList<String> AnsewerL;
	
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("sample_input_43.txt"));

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
			// Input ���
//			printInput(map);
			// �����ִ±� ī��Ʈ
			initRoot(map);
			// �����ִ±� ã��
			findRoot();
			
			for (int i=0; i < AnsewerL.size(); i++) {
				System.out.println("AnsewerL : " + i + " " + AnsewerL.get(i).toString());
			}
			
			// ǥ�����(ȭ��)���� ����� ����մϴ�.
//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					System.out.print(map[i][j]);
//					if (map[i][j] == 'H') ++AnswerN;
//				}
//				System.out.print('\n');
//			}
//			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
	
	private static void findRoot() {
		AnsewerL = new ArrayList<String>();
		int x=0;
		int y=0;
		
		if (Root[0][0] > 0) {
			do {
				if(Success != 0) break;
				findNext(0, 0, AnsewerL);
				
			}
			while(true) ;
		}
		
	}
	
	private static void findNext(int x, int y, ArrayList<String> a) {
		System.out.println("findNext " + x + ", " + y);
		
		if (x == N-1 && y == N-1) {
			Success = 1;
		} 
		else if (Root[0][1] == 0 && Root[1][0] == 0) {
			Success = -1;
		}
		else {
			
			StringBuffer sb = new StringBuffer();
	
			// ��
			if (isPrev(x,y+1,a) && Root[x][y] > 0 && y+1 < N && Root[x][y+1] > 0) {
				sb.append(Integer.toString(x) + "," + Integer.toString(y+1));
				a.add(sb.toString());
				findNext(x, y+1, a);
			}
			// ��
			else if (isPrev(x+1,y,a) && Root[x][y] > 0 && x+1 < N && Root[x+1][y] > 0) {
				sb.append(Integer.toString(x+1) + "," + Integer.toString(y));
				a.add(sb.toString());
				findNext(x+1, y, a);
			}
			// ��
			else if (isPrev(x,y-1,a) && Root[x][y] > 0 && y-1 >= 0 && Root[x][y-1] > 0) {
				sb.append(Integer.toString(x) + "," + Integer.toString(y-1));
				a.add(sb.toString());
				findNext(x, y-1, a);
			}
			// ��
			else if (isPrev(x-1,y,a) && Root[x][y] > 0 && x-1 >= 0 && Root[x-1][y] > 0) {
				sb.append(Integer.toString(x-1) + "," + Integer.toString(y));
				a.add(sb.toString());
				findNext(x-1, y, a);
			}
			else {
				minusRoot(x, y, a);
			}
		}
		
	}
	
	private static boolean minusRoot(int x, int y, ArrayList<String> a) {
		if (a.size() < 1) return true;
		
		String[] tmp;
		
		for (int i=a.size()-1; i >=0; i--) {
			int x1, y1;
			tmp = a.get(i).split(",");
			x1 = new Integer(tmp[0].toString());
			y1 = new Integer(tmp[1].toString());
			
			if (Root[x1][y1] > 1) {
				Root[x1][y1] = Root[x1][y1]-1;
				break;
			}
			else if (Root[x1][y1] > 0) Root[x1][y1] = Root[x1][y1]-1; 
			
		}
		
		System.out.println("minusRoot start ----");
		printInput(Root);
		System.out.println("minusRoot End ----");
		
		a.clear();
		
		return true;
	}
	
	private static boolean isPrev(int x, int y, ArrayList<String> a) {
		
		if (a.size() < 1) return true;

		String[] tmp;
//		tmp = a.get(a.size()-1).split(",");
		
		for (int i=a.size()-1; i >=0; i--) {
			tmp = a.get(i).split(",");
			if (Integer.toString(x).equals(tmp[0].toString()) && Integer.toString(y).equals(tmp[1].toString())) {
				return false;
			}
		}
		return true;
	}
	// ���� �ִ� �� ī��Ʈ
	private static void initRoot(char[][] in) {
		Root = new int[N][N];
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				cnt = 0;
				// O �� 0, X �� -1
				if(in[i][j] == 'O') {
					// ��
					if(j+1 < N && in[i][j+1] == 'O') cnt++;
					// ��
					if(j-1 >= 0 && in[i][j-1] == 'O') cnt++;
					// ��
					if(i+1 < N && in[i+1][j] == 'O') cnt++;
					// ��
					if(i-1 >= 0 && in[i-1][j] == 'O') cnt++;
					
					Root[i][j] = cnt;
				}
				else Root[i][j] = 0;
				
			}
		}
		Root[N-1][N-1] = 1;
		
		printInput(Root);
	}
	
	private static void printInput(char[][] in) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(in[i][j]);
			}
			System.out.print('\n');
		}
	}
	
	private static void printInput(int[][] in) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(in[i][j]);
			}
			System.out.print('\n');
		}
	}
}

