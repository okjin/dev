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
import java.util.ArrayList;
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

	static Boolean[] Visited;
	static Queue<Node> queue;
	static ArrayList<String> Inmap;
	
	static int A;		// 배열크기
	
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
			N = sc.nextInt(); // 고객 수
			A = N + 2;		  // 배열 크기
			sc.nextLine();
			
			String inStr = sc.nextLine();
			String inStrArr[] = inStr.split(" ");
			
			Inmap = new ArrayList<String>();
			Visited = new Boolean[A];
			
			int pCnt = 0;	// 좌표 수
			String pStr = "";
			String eStr = ""; // 종료 지점
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
		
		// 출발제외(i=1), 도착 제외(A-1)에 고객 방문
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

