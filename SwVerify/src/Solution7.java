/*
 * 기지국
 * 
 */

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution7
{
	static int N;
	static int AnswerN;
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("sample_input_72.txt"));

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
					System.out.print(map[i][j]);
				}
				System.out.print('\n');
			}
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 여러분의 정답은 AnswerN에 저장되는 것을 가정하였습니다.
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
			
			//가로, 세로
			for(int i = 0; i < N; i++) {
				if (map[i][y] == 'R') map[i][y] = 'X';
				if (map[x][i] == 'R') map[x][i] = 'X';
			}
			
			
			for(int i = 1; i < N; i++) {
				//우상->좌하
				if (y+i < N && x-i >= 0 && map[x-i][y+i] == 'R') {
					map[x-i][y+i] = 'X';
				}
				if (x+i < N && y-i >= 0 && map[x+i][y-i] == 'R' ) {
					map[x+i][y-i] = 'X';
				}
				//좌상->우하
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
			
			// 표준출력(화면)으로 답안을 출력합니다.

			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
	
	
}

