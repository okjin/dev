/*
 * 최단거리 구하기
 *                                                                          
직원 A씨는 회사에서 출발하여 N명의 고객 집을 방문 한 뒤 귀가한다.                               
각각의 위치는 (X,Y)로 주어진다.(0<=X,Y<=100)                                                    
테스트케이스의 첫번째 숫자는 고객의 수를 의미하고,                                              
두번째 줄의 숫자는 순차적으로 회사위치(x,y) 자택위치(x,y) 고객위치(x,y)... 이다.                
(X1,Y1)과 (X2,Y2)의 거리는 |X1-X2|+|Y1-Y2| 이다.                                                
직원A가 회사에서 출발해 각 고객의 집을 거쳐 퇴근하는 최단거리를 구하라.                         
                                                                                                
아래의 경우 고객의 수는 5명,                                                                    
회사위치(0,0) 직원의 집(100,100) 고객1(20,30) 고객2(10,5) 고객3(70 20) 고객4(40 30) 고객5(60 50)
                                                                                                
테스트케이스 :                                                                                  
5                                                                                              
0 0 100 100 20 30 10 5 70 20 40 30 60 50       
 
 */

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution6
{
	static int N;
	static Boolean[][] Visited;
	static Queue<Node> queue;
	static 
	
	final static int A = 100;		// 배열크기
	
	private static class Node {
		private int x, y;
		private int distance;
		
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("sample_input_61.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 고객 수

			char[][] map = new char[N][N];
			Visited = new Boolean[N][N];
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}
			
			initVisited();
			
			queue = new LinkedList<Node>();
			queue.add(new Node(0,0));
			Visited[0][0] = true;
			
			DFS(0,0,map);
			
			System.out.println("---" + queue.size());
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				System.out.println("#"+test_case+" "+node.x+" "+node.y);
			}
		}
	}
	
	private static void initVisited() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				Visited[i][j] = false;
			}
		}
	}

	private static void DFS(int x, int y, char[][] map) {
		
		if (x == N-1 && y == N-1) {
			System.out.println("Arrived!!!");
			return;
		}
		else {
			// 동
			if (y < N-1 && map[x][y+1] == 'O' && !Visited[x][y+1]) {
				queue.add(new Node(x, y+1));
				Visited[x][y+1] = true;
				DFS(x, y+1, map);
			}
			// 남
			else if (x < N-1 && map[x+1][y] == 'O' && !Visited[x+1][y]) {
				queue.add(new Node(x+1, y));
				Visited[x+1][y] = true;
				DFS(x+1, y, map);
			}
			// 서
			else if (y > 0 && map[x][y-1] == 'O' && !Visited[x][y-1]) {
				queue.add(new Node(x, y-1));
				Visited[x][y-1] = true;
				DFS(x, y-1, map);
			}
			// 북
			else if (x > 0 && map[x-1][y] == 'O' && !Visited[x-1][y]) {
				queue.add(new Node(x-1, y));
				Visited[x-1][y] = true;
				DFS(x-1, y, map);
			}
			else {
				if (x == 0 && y == 0) return;
				initVisited();
				map[x][y] = 'X';
				
				queue = new LinkedList<Node>();
				queue.add(new Node(0,0));
				Visited[0][0] = true;
				DFS(0,0,map);
			}
		}
	}
}

