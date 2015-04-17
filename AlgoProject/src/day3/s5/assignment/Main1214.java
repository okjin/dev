package day3.s5.assignment;

import java.util.Scanner;

public class Main1214 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int count = sc.nextInt();
		long values[] = new long[count];		
		for (int i = 0; i < count; i++) {
			values[i] = sc.nextLong();
		}	
		sc.close();

		long width = 0;
		long area = 0, maxArea = 0;
		for (int i = 0; i < count; i++) {
			width = 1;//i의 기본 너비
			//왼쪽가능여부
			for(int j=i-1; j>=0; j--){
				if(values[i]>values[j]){
					break;
				}
				width++;				
			}
			//오른쪽 가능여부
			for (int j = i+1; j < count; j++) {
				if(values[i]>values[j]){
					break;
				}
				width++;
			}		
			area = width*values[i];	//면적구하기	
			if(area>maxArea){  //최대 면적
				maxArea = area;
			}
		}		
		System.out.println(maxArea);
	}	
}
