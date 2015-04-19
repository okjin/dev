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
import java.util.ArrayList;
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

	static Boolean[] Visited;
	static Queue<Node> queue;
	static ArrayList<String> Inmap;
	
	static int A;		// �迭ũ��
	
	private static class Node {
		private int x, y;
		private int distance;
		
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
		public Node(String tmp, int distance) {
			String[] xy = tmp.split(",");
			this.x = Integer.parseInt(xy[0]);
			this.y = Integer.parseInt(xy[1]);
			this.distance = distance;
		}
		
		public void print() {
			System.out.println("Node x " + this.x + " y " + this.y + " distance " + this.distance);
		}
	}
	
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("sample_input_62.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // �� ��
			A = N + 2;		  // �迭 ũ��
			sc.nextLine();
			
			String inStr = sc.nextLine();
			String inStrArr[] = inStr.split(" ");
			
			Inmap = new ArrayList<String>();
			Visited = new Boolean[A];
			
			int pCnt = 0;	// ��ǥ ��
			String pStr = "";
			String eStr = ""; // ���� ����
			for (int i = 0; i < inStrArr.length; i++) {

				if (i % 2 == 1) {
					pCnt++;
					if (pCnt == 2) eStr = pStr+","+inStrArr[i]+"";
					else {
						Inmap.add(pStr+","+inStrArr[i]+"");
					}
					pStr = "";
				}
				else {
					pStr = inStrArr[i]+"";
				}
			} 
			Inmap.add(eStr);

			System.out.println("Inmap : " + Inmap.toString());
			
			initVisited();
			
			queue = new LinkedList<Node>();
			queue.add(new Node(0,0,9999));
			Visited[0] = true;
			
			for (int i=0; i < A; i++) {
				BFS();
			}
			
			Node node1 = queue.poll();
			node1.print();
			
			System.out.println("---" + queue.size());
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				System.out.println("#"+test_case+" "+node.x+" "+node.y);
			}
		}
	}
	
	private static void BFS() {
		
		// �������(i=1), ���� ����(A-1)�� �� �湮
		for (int i=1; i < A-1; i++) {
			Node node = queue.poll();
			String tmp = Inmap.get(i);
			int dis = calc (node, tmp);
			
			if (node.distance > dis) {
				queue.add(new Node(tmp,dis));
			}
			else {
				queue.add(new Node(tmp, node.distance));
			}
		}
		
		System.out.println("Arrived!!!");
	}
	
	private static int calc(Node node, String tmp) {
		String[] xy = tmp.split(",");
		int x1 = Integer.parseInt(xy[0]);
		int y1 = Integer.parseInt(xy[1]);
		
		int x = node.x > x1 ? node.x - x1 : x1 - node.x ;
		int y = node.y > y1 ? node.y - y1 : y1 - node.y ;
		
		return x + y;
	}
	
	private static void initVisited() {
		for(int i = 0 ; i < Visited.length ; i++) {
			Visited[i] = false;
		}
	}


}

