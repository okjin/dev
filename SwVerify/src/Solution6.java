/*
 * �ִܰŸ� ���ϱ�
 *                                                                          
���� A���� ȸ�翡�� ����Ͽ� N���� �� ���� �湮 �� �� �Ͱ��Ѵ�.                               
������ ��ġ�� (X,Y)�� �־�����.(0<=X,Y<=100)                                                    
�׽�Ʈ���̽��� ù��° ���ڴ� ���� ���� �ǹ��ϰ�,                                              
�ι�° ���� ���ڴ� ���������� ȸ����ġ(x,y) ������ġ(x,y) ����ġ(x,y)... �̴�.                
(X1,Y1)�� (X2,Y2)�� �Ÿ��� |X1-X2|+|Y1-Y2| �̴�.                                                
����A�� ȸ�翡�� ����� �� ���� ���� ���� ����ϴ� �ִܰŸ��� ���϶�.                         
                                                                                                
�Ʒ��� ��� ���� ���� 5��,                                                                    
ȸ����ġ(0,0) ������ ��(100,100) ��1(20,30) ��2(10,5) ��3(70 20) ��4(40 30) ��5(60 50)
                                                                                                
�׽�Ʈ���̽� :                                                                                  
5                                                                                              
0 0 100 100 20 30 10 5 70 20 40 30 60 50       
 
 */

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution6
{
	static int N;
	static Boolean[][] Visited;
	static Queue<Node> queue;
	static 
	
	final static int A = 100;		// �迭ũ��
	
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
			N = sc.nextInt(); // �� ��

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

