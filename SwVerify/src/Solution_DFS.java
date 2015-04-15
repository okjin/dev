/*
 * 미로 길찾기 (DFS)
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution_DFS
{
	static int N;
	static Boolean[][] Visited;
	
	private static class Node {
		private int x, y;
		private int distance;
		
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("sample_input_43.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();
		

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();

			char[][] map = new char[N][N];
			Visited = new Boolean[N][N];
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}
			

			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					Visited[i][j] = false;
				}
			}
			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(new Node(0,0,1));
			Visited[0][0] = true;
			
			DFS(0,0,map, queue);
			
			System.out.println("---" + queue.size());
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				System.out.println("#"+test_case+" "+node.x+" "+node.y);
			}
			

		}
	}
	

	private static void DFS(int x, int y, char[][] map, Queue<Node> queue) {
//		Node node = queue.poll();
//		int x = node.x;
//		int y = node.y;
//		int d = node.distance;
		
//		System.out.println("222 : " + queue.size());
		System.out.println("DFS : " + x + " " + y);
		
		if (x == N-1 && y == N-1) {
			System.out.println("Arrived!!!");
		}
		else {
			// 동
			if (y < N-1 && map[x][y+1] == 'O' && !Visited[x][y+1]) {
				queue.add(new Node(x, y+1));
				Visited[x][y+1] = true;
				DFS(x, y+1, map, queue);
			}
			
			// 남
			if (x < N-1 && map[x+1][y] == 'O' && !Visited[x+1][y]) {
				queue.add(new Node(x+1, y));
				Visited[x+1][y] = true;
				DFS(x+1, y, map, queue);
			}
			
			// 서
			if (y > 0 && map[x][y-1] == 'O' && !Visited[x][y-1]) {
				queue.add(new Node(x, y-1));
				Visited[x][y-1] = true;
				DFS(x, y-1, map, queue);
			}
			
			// 북
			if (x > 0 && map[x-1][y] == 'O' && !Visited[x-1][y]) {
				queue.add(new Node(x-1, y));
				Visited[x-1][y] = true;
				DFS(x-1, y, map, queue);
			}
		}
	}
	
	private static void printInput(Object[][] in) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(in[i][j]);
			}
			System.out.print('\n');
		}
	}

}

