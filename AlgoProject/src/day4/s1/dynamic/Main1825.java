package day4.s1.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1825 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int targetMoney = sc.nextInt(); // ���ڱݾ�
		int n = sc.nextInt(); //�����
		
		int[][] benefits = new int[n+1][targetMoney+1];
		// i=0 ��꿡�� ����
		for (int i = 1; i <=targetMoney; i++) {
			sc.nextInt();  //���ڱݾ��� �ε����� ó��
			for(int j=1; j<=n; j++){
				benefits[j][i] = sc.nextInt();
			}
		}
		// �Է°�� Ȯ��
		/*	for (int[] is : benefits) {
			System.out.println(Arrays.toString(is));
		}*/
		
		int[][] results = new int[n+1][targetMoney+1];
		int[][] keeps = new int[n+1][targetMoney+1];
				
		int tempBenefit = 0 , maxBenefit = 0;
		int temp = 0;
		for (int item = 1; item <= n; item++) { // �������ŭ �����ش�
			for (int money = 1; money <= targetMoney; money++) { // ���ڱݾ��� �й�
				maxBenefit = 0;
				temp = 0;
				for (int k = 0; k <= money; k++) {
					// Max {F[i-1,j-k] +C[i,k]} ��, 0<= k<=j) 
					tempBenefit = results[item-1][money-k]+benefits[item][k];
					if(tempBenefit>maxBenefit){
						maxBenefit = tempBenefit;
						temp = k; // ���� ����� ���ڱݾ�
					}
				}				
				keeps[item][money] = temp;				
				results[item][money] = maxBenefit;
				System.out.println("--"+results[item][money]+"("+keeps[item][money]+")");
			}
		}		
		System.out.println(results[n][targetMoney]);
		
		int[] set = new int[n+1];
		int tempM = targetMoney;
		for(int i=n;i>=1;i--){
			set[i]=keeps[i][tempM];
			tempM-=keeps[i][tempM];
		}		
		for(int i=1; i<=n; ++i){
			System.out.print(set[i]+" ");
		}
		sc.close();
	}
}



