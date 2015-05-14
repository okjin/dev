
import java.util.Arrays;


public class Queen {

	public static void main(String[] args) {
		
		/*
		 *  n x n 체스판에서 4개의 Queen을 배치하려 한다.
		 *  이때 어떤 Queen도 다른 Queen에게 잡힐 수 있는 곳에 위치해서는 안된다.
		 *  이러한 조건을 만족하는 Queen의 배치도를 출력하시오.
		 */
		
		/*
		 * Backtracking의 이해를 위한 풀이이므로,
		 * 가지치기나 휴리스틱등은 사용하지 않고 가장 단순한 형태로 구현
		 */
		
		int n = 27;
		
		int[][] board = new int[n][n];
		
		if (mark(board, 0)) {
			for (int[] is : board) {
				System.out.println(Arrays.toString(is));
			}
		}
	}

	private static boolean mark(int[][] board, int r) {
		
		if (r == board.length) {
			return true;
		}
		
		for (int c = 0; c < board.length; c++) {
			if (isPossible(board, r, c)) {
				board[r][c] = 1;
				if (mark(board, r+1)) {
					return true;
				}
				board[r][c] = 0;
			}
		}
		
		return false;
	}

	private static boolean isPossible(int[][] board, int targetR, int targetC) {
		
		for (int c = 0; c < board.length; c++) {
			if (board[c][targetC] == 1) {
				return false;
			}
		}
		
		int r = targetR;
		int c = targetC;
		while (true) {
			r--;
			c--;
			if (r < 0 || c < 0) {
				break;
			} else {
				if (board[r][c] == 1) {
					return false;
				}
			}
		}

		r = targetR;
		c = targetC;
		while (true) {
			r--;
			c++;
			if (r < 0 || c == board.length) {
				break;
			} else {
				if (board[r][c] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
}
