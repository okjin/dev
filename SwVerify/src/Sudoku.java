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
	static int Success = 0;
	static String[][] AnswerArr;
	static int WrongCnt = 0;
	
	static final int C = 9;	// 스도쿠 배열 크기 9 * 9
	
	
	static ArrayList<String> TmpList;
	static ArrayList<String> AnswerList;
	
	public static void main(String args[]) throws Exception
	{

		
		System.setIn(new FileInputStream("sudoku_2.txt"));

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
			
			AnswerArr = new String[N][2];	// 틀린위치, 정답

			char[][] map = new char[C][C];
			for(int i = 0 ; i < C ; i++) {
				for(int j = 0 ; j < C ; j++) {
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}

			//--------------------------------------
			
			// Input 출력
			printInput(map);

			// 틀린 곳 찾기 tmpList 저장
			WrongCnt = 0;
			findWrongPosition(map);
			
			for (int i=0; i < TmpList.size(); i++) {
				System.out.println("TmpList : " + i + " " + TmpList.get(i).toString());
			}
			
			// 틀린 곳 정확하게 검증하고 맞는 답 찾기
			for (int i=0; i < TmpList.size(); i++) {
				int x, y;
				String[] tmp = TmpList.get(i).split(",");
				
				// 앞 위치 검증
				x = new Integer(tmp[0].charAt(0)+"");
				y = new Integer(tmp[0].charAt(1)+"");
				
				if (findWrongVer(x, y, map) > -1) {
					System.out.println("Got it !!!!" + x + "," + y);
					AnswerArr[i][0] = tmp[0].charAt(0)+" "+ tmp[0].charAt(1)+"";
					AnswerArr[i][1] = fixIt(x, y, map);
				}
				
				// 뒷 위치 검증
				x = new Integer(tmp[1].charAt(0)+"");
				y = new Integer(tmp[1].charAt(1)+"");
				
				if (findWrongVer(x, y, map) > -1) {
					System.out.println("Got it !!!!" + x + "," + y);
					AnswerArr[i][0] = tmp[1].charAt(0)+" "+ tmp[1].charAt(1)+"";
					AnswerArr[i][1] = fixIt(x, y, map);
				}
			}
			
			// 표준출력(화면)으로 답안을 출력합니다.
			for(int i = 0 ; i < N ; i++) {
				System.out.println("#" + test_case + " : "+AnswerArr[i][0]+" "+AnswerArr[i][1]);
			}
		}
	}
	
	// 정답 찾기
	private static String fixIt(int x, int y, char[][] a) {
		
		char[] tmp = {'x','x','x','x','x','x','x','x','x','x'};		// 10개 'x' 로 초기화(배열은 0부터니까)
		
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
	
	// 틀린 위치 찾기
	private static void findWrongPosition(char[][] a) {
		TmpList = new ArrayList<String>();
		
		// 가로 검색
		for (int i=0; i < C; i++) {
			if (N == WrongCnt) break;
			
			for (int j=0; j < C; j++) {
				if (N == WrongCnt) break;
				findWrongHor(i, j, a);
			}
		}

	}
	
	// 가로 검색(x 축 고정, y만 이동하면서), 중복된 위치 저장
	private static int findWrongHor(int x, int y, char[][] a) {
		
		String tmp = "";
		
		for (int i = y+1; i < C; i++) {
			// 자신 위치는 Skip, 현재 위치 값과 순차적으로 비교
			if (a[x][y] == a[x][i]) {
				tmp = Integer.toString(x) + Integer.toString(y) + "," + Integer.toString(x) + Integer.toString(i);
				TmpList.add(tmp);	// tmpList 에 저장할때는 앞,뒤 자표 어느값이 잘못된 것인지 모름 (틀린 위치 찾기를 통해서 확인)
				WrongCnt ++;
			}
		}
		
		return 0;
	}
	
	// 세로 검색(y 축 고정, x만 이동하면서) 검증용(세로로 검색해서 중복되면 해당 위치가 잘못된 값)
	private static int findWrongVer(int x, int y, char[][] a) {
		
		for (int i=0; i < C; i++) {
			// 자신 위치는 Skip, 현재 위치 값과 순차적으로 비교
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

