package day3.s3.greedy;

import java.util.Scanner;

public class GreedyEx2 {

	public static void main(String[] args) {
		int[] gap={0,20,25,35,17,24,20,32,13};
		Scanner s=new Scanner(System.in);
		System.out.print("���Ḧ ���� ä��� �� ������ �޸��� �ִ°�? ������ �Է��ϼ���:");
		int mile=s.nextInt();
		System.out.println();
		
		int totalMile=0;
		for(int i=1; i<gap.length-1;i++){
			totalMile+=gap[i];				//�����Ұ� �ִµ� ���� ����.
			if((totalMile+gap[i+1])> mile){  // ���� ������ ���� �� �� �ִ��� Ȯ���Ѵ�.
				System.out.println("����~"+(i)); // �̹� �����ҿ��� ä���
				totalMile=0;                  //�ٽ� �ʱ�ȭ
			}			
		}
	}
}
