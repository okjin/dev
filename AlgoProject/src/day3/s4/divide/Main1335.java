package day3.s4.divide;

import java.util.Scanner;
//색종이 자르기
public class Main1335 {
	static int wcnt;
	static int bcnt;

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] paper=new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++ ){
				paper[i][j]=s.nextInt();
			}
		}
		s.close();
		
		getCount(paper,0,0,n);
		System.out.println(wcnt);
		System.out.println(bcnt);
	}
	public static void getCount(int[][] p,int r,int c,int n){
		
		int v=p[r][c];
		boolean flag=true;
		EXIT:
		for(int i=r; i<r+n; i++){
			for(int j=c; j<c+n; j++){
				if(v!=p[i][j]){
					flag=false;
					break EXIT;
				}
			}
		}
		if(flag){
			if(v==1){
				bcnt++;
			}else{
				wcnt++;
			}
			return;
		}else{
			getCount(p,r,c,n/2);
			getCount(p,r+n/2,c,n/2);
			getCount(p,r,c+n/2,n/2);
			getCount(p,r+n/2,c+n/2,n/2);			
		}
	}

}
