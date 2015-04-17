package day3.s3.greedy;

import java.util.Scanner;

public class Main1141 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [] input = new int [num];
		for(int i=0; i<num; i++){
			input[i] = sc.nextInt();
		}
		sc.close();
		
		long count = 0;
		for(int i=0; i<num-1; i++){
			for(int j=i+1; j<num; j++){
				if(input[i] <= input[j]) break;
				count++;
			}
		}		
		System.out.println(count);
	}
}
