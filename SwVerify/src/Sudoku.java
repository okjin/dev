/*
 * 스도쿠 틀린 위치,답 찾기
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
	
	static final int C = 9;	// 스도쿠 배열 크기 9 * 9
	
	
	static ArrayList<String> TmpList;
	static ArrayList<String> AnswerList;
	
	public static void main(String args[]) throws Exception
	{

		
		System.setIn(new FileInputStream("sudoku_1.txt"));

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

			N = sc.nextInt();	// 틀린 갯수
			
//			AnswerArr = new String[N][2];	// 틀린위치, 정답

			char[][] map = new char[C][C];
			for(int i = 0 ; i < C ; i++) {
				for(int j = 0 ; j < C ; j++) {
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

			// 틀린 위치 찾기
			findWrongPosition(map);
			
			for (int i=0; i < TmpList.size(); i++) {
				System.out.println("AnsewerL : " + i + " " + TmpList.get(i).toString());
			}
			
			// 표준출력(화면)으로 답안을 출력합니다.
//			for(int i = 0 ; i < N ; i++) {
//				
//				System.out.println("#"+test_case+" : "+AnswerArr[i][0]+" "+AnswerArr[i][1]);
//			}
		}
	}
	
	// 틀린 위치 찾기
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
	
	// 현재 위치에서 가로, 세로 검색해서 중복된 위치 저장
	private static int findWrongByChar(int x, int y, char[][] a) {
		
		String tmp = "";
		
		if (N == WrongCnt) return 1;
		
		// 가로 검색
		for (int i=0; i < C; i++) {
			// 자신 위치는 Skip, 자신 위치 값과 순차적으로 비교
			if (i != y && a[x][y] == a[x][i]) {
				tmp = Integer.toString(x) + Integer.toString(y) + Integer.toString(x) + Integer.toString(i);
				TmpList.add(tmp);
				WrongCnt ++;
				break;
			}
		}
		
		// 세로 검색 
		for (int i=0; i < C; i++) {
			// 자신 위치는 Skip, 자신 위치 값과 순차적으로 비교
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

