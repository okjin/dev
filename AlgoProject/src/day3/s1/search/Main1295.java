package day3.s1.search;

import java.util.Arrays;
import java.util.Scanner;

public class Main1295 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//정렬된 입력데이터
		int n = sc.nextInt();
		int[] ia = new int[n];
		for (int i = 0; i < n; i++) {
			ia[i] = sc.nextInt();
		}
		//찾을 데이터
		int m=sc.nextInt();
		int [] ib=new int [m];
		//검색
		for (int i = 0; i < m; i++) {
			ib[i] = sc.nextInt();
			if(Arrays.binarySearch(ia, ib[i])>=0){
			System.out.println(Arrays.binarySearch(ia, ib[i])+1);}
			else{
				System.out.println(0);
			}
		}
	}
}