package day4.s2.back;

import java.util.Arrays;
import java.util.Scanner;

public class Main1681 {
	static int[][] tour;
	static int min = 0;
	static int n=0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt()+1;  // 0행 0열을 사용하지 않기 위해 하나 큰값
		tour = new int[n][n];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				tour[i][j] = s.nextInt();
			}
		}
		s.close();
		
		min=100*n;
		int[] cc=new int[n];
		boolean[] cflag=new boolean[n];  //****속도를 향상시키기 위해 사용여부 배열***
		go(1,1, cc, cflag); 
		System.out.println(min);
	}

	public static  void  go(int r,int c, int[] cc, boolean[] cflag ){     
			if(getFlag(cflag)) {				
				//System.out.println("========="+Arrays.toString(cc));
				//여기서 합계랑 최소값 비교		
				if(tour[c][1]==0) return;
				cc[c]=1;
				int sum=0;	
				for(int k=1; k<n; k++){
					sum+=tour[k][cc[k]];
				}
				if(min >sum) min=sum;
			}else{
				int[] col=cc.clone();   // 재귀호출이기 때문에 각 재귀호출의 값을 저장하기 위해 배열 복사
				//	System.out.println(Arrays.toString(col)+":"+Arrays.toString(cflag));
				r=c;
				for(int j=1; j<n;j++){	
					if(tour[r][j]==0 ||cflag[j])continue; // 값이 0이거나 이미 사용되었다면 스킵
					col[r]=j;
					if(j==1 && !getFlag(cflag)) continue;  // 1은 홈, 아직 순회하지 않은 사이트가 있는데 1로 가면 스킵
					cflag[j]=true;		// 이 사이트는 갔다옴
					go(r, j,col, cflag); // 저장 가능한지를 재귀 호출로 체크
					cflag[j]=false;      // 다른 
				}
			}
		//}
	}
	public static boolean getFlag(boolean[] f){
		for(int i=2; i<n; i++){
			if(!f[i]) return false;  //순회할 사이트 남아 있음
		}
		return true;  //모두 순회함
	}

}
