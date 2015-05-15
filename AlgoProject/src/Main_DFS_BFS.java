import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main_DFS_BFS {
 /*
4 5 1
1 2
1 3
1 4
2 4
3 4

  */
    private static boolean visited[];
 
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
 
        boolean map[][] = new boolean[N + 1][N + 1];
 
        int src, dst;
 
        for(int i = 0; i < M; i++) {
            src = sc.nextInt();
            dst = sc.nextInt();
             
            map[dst][src] = map[src][dst] = true;
        }
        System.out.print("  ");
        for(int i = 1; i <= N; i++) {
        	System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 1; i <= N; i++) {
        	System.out.print(i + " ");
            for(int j = 1; j <= N; j++) {
            	System.out.print((map[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        
        System.out.println();
 
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        System.out.print(V);
        DFS(map, V);
        System.out.println();
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        BFS(map, V);
    }
 
    private static void BFS(boolean[][] map, int v) {
        Queue q = new LinkedList();
 
        System.out.print(v);
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int src = (Integer) q.poll();
 
            for(int i = 1; i < map[src].length; i++) {
                if(map[src][i]) {
                    if(!visited[i]) {
                        visited[i] = true;
                        System.out.print(" " + i);
                        q.add(i);
                    }
                }
            }
        }
    }
 
    private static void DFS(boolean map[][], int v) {
        visited[v] = true;
 
        for(int i = 1; i < map[v].length; i++){
            if(map[v][i]) {
                if(!visited[i]) {
                    System.out.print(" " + i);
                    DFS(map, i);
                }
            }
        }
    }
}