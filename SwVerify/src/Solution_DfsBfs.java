
/*
 * DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Solution_DfsBfs {

	private static Boolean visitDfs[];
	private static ArrayList<Edge>[] edges;
	private static int[][] BFS;
	private static Scanner sc;
	private static String DfsRst = "";
	private static String BfsRst = "";

	private static int rear = 0, front = 0; // 전단과 후단을 나타내는 변수
	private static int queue[], search[]; // 큐와 방문한 정점을 체크하고 위함
	private static int N, M, V;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("sample_DfsBfs.txt"));
		sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		edges = new ArrayList[N + 1];
		visitDfs = new Boolean[N + 1];
		BFS = new int[N + 1][N + 1];
		queue = new int[N + 1];
		search = new int[N + 1];

		for (int i = 0; i <= N; ++i) {
			edges[i] = new ArrayList<Edge>();
			visitDfs[i] = false;
		}

		for (int m = 0; m < M; m++) {
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();
			edges[u].add(new Edge(v, 1));

			BFS[u][v] = 1;
			BFS[v][u] = 1;
		}

		dfs(V);
		System.out.println(DfsRst);

		BfsRst += " " + new Integer(V);
		bfs(V);
		System.out.println(BfsRst);

	} // main

	private static void dfs(int node) {
		visitDfs[node] = true;

		DfsRst += " " + new Integer(node);

		for (Edge edge : edges[node]) {
			if (!visitDfs[edge.next]) {
				dfs(edge.next);
			}
		}
	}

	public static void bfs(int s) {
		search[s] = 1;
		queue[rear++] = s;
		while (front < rear) {
			s = queue[front++];
			for (int i = 1; i <= N; i++) {
				if (BFS[s][i] == 1 && search[i] != 1) {
					search[i] = 1;
					BfsRst += " " + new Integer(i);
					queue[rear++] = i;
				}
			}
		}
	}

}

class Edge {
	public int next;
	public int weight;

	public Edge(int next, int weight) {
		this.next = next;
		this.weight = weight;
	}
}
