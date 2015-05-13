/*
 * 미로 탐색 (최단 거리)
 * https://www.acmicpc.net/problem/2178
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class P2178 {
	
	private static class Location{
		public final int x;
		public final int y;
		public final int distance;
		public Location(int x, int y, int distance){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int m = sc.nextInt();
		sc.nextLine();

		final int maze[][] = new int[n][m];
		for(int i=0; i<n; i++){
			final char[] line = sc.nextLine().toCharArray();
			for(int j=0; j<m; j++){
				maze[i][j] = Integer.parseInt(String.valueOf(line[j]));
			}
		}//end of getting inputs
		
		//BFS
		final boolean[][] visited = new boolean[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				visited[i][j] = false;
			}
		}
		
		final int[][] distances = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				distances[i][j] = 0;
			}
		}
		
		final Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(0, 0, 1));
		visited[0][0] = true;

		while(!queue.isEmpty()){
			final Location location = queue.poll();
			final int x = location.x;
			final int y = location.y;
			final int distance = location.distance;
			
			System.out.println("x : " + x + "Y : " + y);

			distances[x][y] = distance;

			if(x>0 && maze[x-1][y] == 1 && !visited[x-1][y]){
				queue.add(new Location(x-1, y, distance+1));
				visited[x-1][y] = true;
			}
			if(x<n-1 && maze[x+1][y] == 1 && !visited[x+1][y]){
				queue.add(new Location(x+1, y, distance+1));
				visited[x+1][y] = true;
			}
			if(y>0 && maze[x][y-1] == 1 && !visited[x][y-1]){
				queue.add(new Location(x, y-1, distance+1));
				visited[x][y-1] = true;
			}
			if(y<m-1 && maze[x][y+1] == 1 && !visited[x][y+1]){
				queue.add(new Location(x, y+1, distance+1));
				visited[x][y+1] = true;
			}
		}
		System.out.println(distances[n-1][m-1]);
		sc.close();
	}
}
