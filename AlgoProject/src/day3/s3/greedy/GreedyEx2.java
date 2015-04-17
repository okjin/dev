package day3.s3.greedy;

import java.util.Scanner;

public class GreedyEx2 {

	public static void main(String[] args) {
		int[] gap={0,20,25,35,17,24,20,32,13};
		Scanner s=new Scanner(System.in);
		System.out.print("연료를 가득 채우면 몇 마일을 달릴수 있는가? 마일을 입력하세요:");
		int mile=s.nextInt();
		System.out.println();
		
		int totalMile=0;
		for(int i=1; i<gap.length-1;i++){
			totalMile+=gap[i];				//주유소가 있는데 까지 간다.
			if((totalMile+gap[i+1])> mile){  // 다음 주유소 까지 갈 수 있는지 확인한다.
				System.out.println("주유~"+(i)); // 이번 주유소에서 채우고
				totalMile=0;                  //다시 초기화
			}			
		}
	}
}
