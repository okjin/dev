import java.io.IOException;
import java.util.Scanner;

public class Main_미로탐색_Back {
	static int [][] board;
	static int row, col;
	public static void main(String[] args) throws IOException {
		Scanner s=new Scanner(System.in);
		row = s.nextInt();
		col = s.nextInt();
		board = new int [row][col];
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				board[i][j] = s.nextInt();
			}
		}		
		s.close();
		
		search(0,0);
		System.out.println(board[row-1][col-1]);
		for(int[] i : board){
			for(int a : i) System.out.print(a+"\t");
			System.out.println();
		}
	}

	private static void search(int i, int j) {
		if(i>=col && j>=row) return;
		//아래
		if(i+1<row&&j>=0&&board[i+1][j]==1){
			board[i+1][j] = board[i][j]+1;
			search(i+1,j);
		} else if(i+1<row&&j>=0&&board[i+1][j]>board[i][j]+1){
			board[i+1][j] = board[i][j]+1;
			search(i+1,j);
		}
		//오른쪽
		if(i>=0&&j+1<col&&board[i][j+1]==1){
			board[i][j+1] = board[i][j]+1;
			search(i,j+1);
		} else if(i>=0&&j+1<col&&board[i][j+1]>board[i][j]+1){
			board[i][j+1] = board[i][j]+1;
			search(i,j+1);
		}
		//위
		if(i-1>=0&&j>=0&&board[i-1][j]==1){
			if(i-1==0&&j==0) return;
			board[i-1][j] = board[i][j]+1;
			search(i-1,j);
		} else if(i-1>=0&&j>=0&&board[i-1][j]>board[i][j]+1){
			board[i-1][j] =board[i][j]+1;
			search(i-1,j);
		}
		//왼쪽
		if(i>=0&&j-1>=0&&board[i][j-1]==1){
			if(i==0&&j-1==0) return;
			board[i][j-1] = board[i][j]+1;
			search(i,j-1);
		} else if(i>=0&&j-1>=0&&board[i][j-1]>board[i][j]+1){
			board[i][j-1] = board[i][j]+1;
			search(i,j-1);
		}
	}

}
/*

5 7
1 0 1 1 1 1 1
1 0 1 0 0 0 1
1 0 1 1 1 0 1
1 0 1 0 1 0 1
1 1 1 1 1 0 1
 
4 8
1011111
1010101
1010101
1111101

*/
