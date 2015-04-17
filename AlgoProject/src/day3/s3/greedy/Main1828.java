package day3.s3.greedy;

//냉장고

import java.util.Scanner;

public class Main1828 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// 화학물질 수 입력
		int n= s.nextInt(); 
		int[][] ia = new int[n][2];
		for(int i=0; i<n; i++){
			ia[i][0]=s.nextInt();
			ia[i][1]=s.nextInt();
		}
		//최대온도 기준 소트
		for(int i=0; i<n-1; i++){
			for(int j=i; j<n; j++){
				if(ia[i][1]>ia[j][1]){	
					int temp = ia[j][0];
					ia[j][0] = ia[i][0];
					ia[i][0] = temp;
					int temp2 = ia[j][1];
					ia[j][1] = ia[i][1];
					ia[i][1] = temp2;
				}
			}
		}
		int count=0; 
		int start = ia[0][1];
		for(int i=1; i<n; i++){
			if(start<ia[i][0]) {
				count++;
				start = ia[i][1];
			}
		}
		System.out.println(count+1);
	}
}