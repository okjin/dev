package day4.s3.graph;
import java.util.Scanner;

public class Main1230 {

	static int[][] ar; // ������ �� �����
	static int n; // ���簢�� ���� ����
	static int z=0; 
	static int maxCnt=0; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ar = new int[n][n]; // �� ���� n�� ���簢��(n<=10)
		boolean[][] check = new boolean[n][n]; //check��
		for (int i = 0; i < n; i++) { // �迭�� �� �ֱ�
			for (int j = 0; j < n; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		check[0][0]=true;
		if(ar[0][0]==2){
			search(0, 0, ar, 1, check);
		}else search(0, 0, ar, 0, check);
		System.out.println(maxCnt);

	}

	private static void search(int x, int y, int[][] ar, int cnt, boolean[][] check) {
		if (x == n-1 && y == n-1){
			maxCnt=Math.max(maxCnt, cnt);
			return;
		}
		//������üũ
		if(x < n-1 && ar[y][x+1] != 1 && !check[y][x+1]){
			check[y][x+1] = true;
			if(ar[y][x+1] == 2) {
				search(x+1, y, ar, cnt+1, check);
			} else{search(x+1,y,ar,cnt,check);}
			check[y][x+1] = false;
		}
		//����üũ
		if(x > 0 && ar[y][x-1] !=1 && !check[y][x-1]){
			check[y][x-1] = true;
			if(ar[y][x-1] == 2){
				search(x-1, y, ar, cnt+1, check);
			}
			else {
				search(x-1, y, ar, cnt, check);
			}
			check[y][x-1] = false;
		}
		//��üũ
		if(y < n-1 && ar[y+1][x]!=1 && !check[y+1][x]){
			check[y+1][x] = true;
			if(ar[y+1][x] == 2) search(x, y+1, ar, cnt+1, check);
			else search(x, y+1, ar, cnt, check);
			check[y+1][x] = false;
		}
		//�Ʒ�üũ
		if(y > 0 && ar[y-1][x] !=1 && !check[y-1][x]){
			check[y-1][x] = true;
			if(ar[y-1][x] == 2) search(x, y-1, ar, cnt+1, check);
			else search(x, y-1, ar, cnt, check);
			check[y-1][x] = false;
		}
	
	
	}
}




/*
8
2 1 1 2 1 2 0 2 
0 2 2 1 1 1 1 2 
0 2 0 0 0 0 0 0 
1 0 1 2 0 1 2 1 
0 2 2 2 0 1 0 2 
0 1 0 1 2 1 0 0 
1 2 2 1 2 2 0 0 
1 2 1 0 1 1 1 2 
*/
