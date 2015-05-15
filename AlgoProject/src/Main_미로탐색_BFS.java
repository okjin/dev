import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_¹Ì·ÎÅ½»ö_BFS{
	private static int step[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.nextLine();
		boolean maze[][] = new boolean[M][N];
		step = new int[M][N];

		for(int i = 0; i < M; i++) {
			String s = sc.nextLine();
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '1') {
					maze[i][j] = true;
				}
				step[i][j] = M * N + 1;
			}
		}

		move(maze, M, N, M * N + 1);
	}

	private static void move(boolean[][] maze, int m, int n, int max) {
		boolean visited[] = new boolean[m * n];
		Queue q = new LinkedList();

		visited[0] = true;
		q.add(0);
		step[0][0] = 1;

		int x;
		int y;
		int cnt = 0;
		while(!q.isEmpty()) {
			int current = (Integer) q.poll();
			x = current / n;
			y = current % n;
			int currentStep = step[x][y];

			if(x + 1 < m && maze[x + 1][y] & step[x + 1][y] > currentStep + 1) {
				q.add((x + 1) * n + y);
				visited[(x + 1) * n + y] = true;
				step[x + 1][y] = currentStep + 1;
			}

			if(y + 1 < n && maze[x][y + 1] && step[x][y + 1] > currentStep + 1) {
				q.add(x * n + (y + 1));
				visited[x * n + (y + 1)] = true;
				step[x][y + 1] = currentStep + 1;
			}

			if(x - 1 >= 0 && maze[x - 1][y] && step[x - 1][y] > currentStep + 1) {
				q.add((x - 1) * n + y);
				visited[(x - 1) * n + y] = true;
				step[x - 1][y] = currentStep + 1;
			}

			if(y - 1 >= 0 && maze[x][y - 1] && step[x][y - 1] > currentStep + 1) {
				q.add(x * n + (y - 1));
				visited[x * n + (y - 1)] = true;
				step[x][y - 1] = currentStep + 1;
			}
		}
		System.out.println(step[m - 1][n - 1]);
	}
}
