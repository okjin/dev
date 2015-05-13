/*
 * �̷� ��ã�� (DFS)
 * 
 */

import java.io.FileInputStream;
import java.text.DateFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution �������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution_DFS
{
	static int N;
	static Boolean[][] Visited;
	static Queue<Node> queue;
	
	private static class Node {
		private int x, y;
		
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
		
		Long stime = System.currentTimeMillis();
		
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
			
			initVisited();
			
			queue = new LinkedList<Node>();
			queue.add(new Node(0,0));
			Visited[0][0] = true;
			
			DFS(0,0,map);

//			System.out.println("---" + queue.size());
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				System.out.println("#"+test_case+" "+node.x+" "+node.y);
			}
			
			Long etime = System.currentTimeMillis();
			Long atime = etime - stime;
			System.out.println("Time : " + atime + "ms");
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
			// ��
			if (y < N-1 && map[x][y+1] == 'O' && !Visited[x][y+1]) {
				queue.add(new Node(x, y+1));
				Visited[x][y+1] = true;
				DFS(x, y+1, map);
			}
			// ��
			else if (x < N-1 && map[x+1][y] == 'O' && !Visited[x+1][y]) {
				queue.add(new Node(x+1, y));
				Visited[x+1][y] = true;
				DFS(x+1, y, map);
			}
			// ��
			else if (y > 0 && map[x][y-1] == 'O' && !Visited[x][y-1]) {
				queue.add(new Node(x, y-1));
				Visited[x][y-1] = true;
				DFS(x, y-1, map);
			}
			// ��
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
