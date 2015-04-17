package day3.s3.greedy;

import java.util.Scanner;

public class GreedyEx1 {
	int[] coin={50,25,20,10,5,1};
	int[] result=new int[coin.length];
	
	public void coinChange(int money){    
		for(int i=0; i<coin.length; i++){
			result[i]= money/coin[i];
			money= money%coin[i];
		}
	}
	public void print(){
		System.out.println("동전 교환 결과");
		for(int i=0; i<coin.length; i++){
			if(result[i] == 0) continue;
			System.out.println(coin[i]+"루피 : "+result[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("동전 교환할 루피를 입력하세요:");
		int money=s.nextInt();
		System.out.println();
		
		GreedyEx1  cc=new GreedyEx1();
		cc.coinChange(money);
		cc.print();
	}
}
