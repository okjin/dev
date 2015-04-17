package day4.s2.back;

import java.util.Arrays;
import java.util.Scanner;

public class Main1889 {

	int cnt=0;
	public static void main(String[] args) {
		Main1889 q=new Main1889();
		Scanner  s=new Scanner(System.in);
		int n=s.nextInt()+1;	 // 0번 행을 제외하고 작업하기 위해 1을 더한다.
		int[] col=new int[n];    //각행에 하나씩만 배치할 수 있기 때문에 1차원, col[i]번째방에 여왕을 배치할 열값을 저장한다.
		q.setQueens(0,col, n);		//여왕을 배치
		System.out.println(q.cnt);
	}
	
	public void setQueens(int i, int[] c, int n){
		if(checking(i, c)){            // col배열에 i번째 행에 값이 들어갈 수 있는지 (아래 26라인에서 col[i+1]=j; i행의 열값을 저장) 만약 성공하지 않았다면 메서드 종료로 재귀 종료
			if(i==n-1) {				 // 재귀호출의 결과 마지막까지 왔다면 성공
				cnt++;
				//System.out.println(Arrays.toString(c));  /// 정답이 궁금하면 주석 풀고~^^
			}
			else{
				int[] col=Arrays.copyOf(c, n);   // 재귀호출이기 때문에 각 재귀호출의 값을 저장하기 위해 배열 복사
				//int[] col=c.clone();   // 재귀호출이기 때문에 각 재귀호출의 값을 저장하기 위해 배열 복사
				for(int j=1; j<n;j++){	// i+1번째 행에 각 열값 (1~n)값을 저장하여 
					col[i+1]=j;
					setQueens(i+1, col, n); // 저장 가능한지를 재귀 호출로 체크
				}
			}
		}
	}
	public boolean checking(int i, int[] col){
		boolean f=true;
		for(int k=1; k<i; k++){		// i번째 행에 열값이 배치 가능하지를 테스트 하기 때문에 1~i-1 행까지 같은지 체크
			if(col[i] == col[k] || Math.abs(col[i]-col[k]) == i-k){//ol[i] == col[k]  열이 같은지 체크 (한행에 하나씩 구하기 때문에 행체크 불필요)
					f=false;									//Math.abs(col[i]-col[k]) == i-k 대각선 체크 (열값차이와 행값차이가 같다면 대각선)
					break;
			}				
		}
		return f;
	}
}
