
/*
 * DFS¿Í BFS
 * https://www.acmicpc.net/problem/1260
 */

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;



class Solution_DfsBfs {
	

	
	public static Boolean visit[];
	public static ArrayList<Edge>[] edges;
	private static Scanner sc;
	
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("sample_DfsBfs.txt"));
		sc = new Scanner(System.in);

		int N, M, V;

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		edges = new ArrayList[N + 1];
		visit = new Boolean[N + 1];
		
		for(int i = 0; i <= N; ++i){
			edges[i] = new ArrayList<Edge>();
			visit[i] = false;
		}
		
		for (int m = 0; m < M; m++) {
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();
			edges[u].add(new Edge(v, 1));
//			edges[v].add(new Edge(u, 1));
		}

		dfs(V);

	} // main

	private static void dfs(int node) {
		visit[node] = true;
		
		System.out
		
		for (Edge edge : edges[node]) {
			if (!visit[edge.next]) {
				dfs(edge.next);
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
