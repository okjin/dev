/*
 * 미로 길찾기
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution4
{
	static int N;
	static int AnswerN;
	static int[][] Root;
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("sample_input_41.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			/*
				각 테스트 케이스를 표준 입력에서 읽어옵니다.
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
			 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 여러분의 정답은 AnswerN에 저장되는 것을 가정하였습니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			AnswerN = 0;
			// Input 출력
			printInput(map);
			// 갈수있는길 카운트
			initRoot(map);
			// 갈수있는길 찾기
			findRoot();
			
//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					
//				}
//			}
			

			
			// 표준출력(화면)으로 답안을 출력합니다.
//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					System.out.print(map[i][j]);
//					if (map[i][j] == 'H') ++AnswerN;
//				}
//				System.out.print('\n');
//			}
			System.out.println("#"+test_case+" "+AnswerN);
		}
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
	
	private static boolean findRoot() {
		ArrayList<String> al = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		int x, y, cnt;
		
		if (Root[0][0] == 0) return false;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {

				findNext(i, j, al);
				
			}
		}
		
		return true;
	}
	
	private static void findNext(int x, int y, ArrayList<String> a) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<Root[x][y]; i++) {
			// 동
			if (isPrev(x,y,a) && Root[x][y] > 0 && y+1 < N && Root[x][y+1] > 0) {
				sb.append(Integer.toString(x) + "," + Integer.toString(y+1));
				a.add(sb.toString());
				findNext(x, y+1, a);
			}
			// 남
			if (isPrev(x,y,a) && Root[x][y] > 0 && x+1 < N && Root[x+1][y] > 0) {
				sb.append(Integer.toString(x+1) + "," + Integer.toString(y));
				a.add(sb.toString());
				findNext(x+1, y, a);
			}
//			// 남
//			if (Root[x][y] > 0 && x+1 < N && Root[x+1][y] > 0) {
//				sb.append(Integer.toString(x+1) + "," + Integer.toString(y));
//				a.add(sb.toString());
//				findNext(x+1, y, a);
//			}
		}
	}
	
	private static boolean isPrev(int x, int y, ArrayList<String> a) {
		
		String[] tmp;
		if (a.size() <= 0) return true;
		
		tmp = a.get(a.size()-1).split(",");
		if (Integer.toString(x).equals(tmp[0].toString()) && Integer.toString(y).equals(tmp[1].toString())) return false;

//		for (int i=0; i<a.size(); i++) {
//			tmp = a.get(i).split(",");
//			
//		}
		return true;
	}
	// 갈수 있는 길 카운트
	private static void initRoot(char[][] in) {
		Root = new int[N][N];
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				cnt = 0;
				// O 면 0, X 면 -1
				if(in[i][j] == 'O') {
					// 동
					if(j+1 < N && in[i][j+1] == 'O') cnt++;
					// 서
//					if(j-1 >= 0 && in[i][j-1] == 'O') cnt++;
					// 남
					if(i+1 < N && in[i+1][j] == 'O') cnt++;
					// 북
//					if(i-1 >= 0 && in[i-1][j] == 'O') cnt++;
					
					Root[i][j] = cnt;
				}
				else Root[i][j] = 0;
				
			}
		}
		Root[N-1][N-1] = 1;
		
		printInput(Root);
	}
}

