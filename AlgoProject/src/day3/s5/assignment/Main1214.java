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
			width = 1;//i�� �⺻ �ʺ�
			//���ʰ��ɿ���
			for(int j=i-1; j>=0; j--){
				if(values[i]>values[j]){
					break;
				}
				width++;				
			}
			//������ ���ɿ���
			for (int j = i+1; j < count; j++) {
				if(values[i]>values[j]){
					break;
				}
				width++;
			}		
			area = width*values[i];	//�������ϱ�	
			if(area>maxArea){  //�ִ� ����
				maxArea = area;
			}
		}		
		System.out.println(maxArea);
	}	
}
