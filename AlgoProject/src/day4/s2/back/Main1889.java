package day4.s2.back;

import java.util.Arrays;
import java.util.Scanner;

public class Main1889 {

	int cnt=0;
	public static void main(String[] args) {
		Main1889 q=new Main1889();
		Scanner  s=new Scanner(System.in);
		int n=s.nextInt()+1;	 // 0�� ���� �����ϰ� �۾��ϱ� ���� 1�� ���Ѵ�.
		int[] col=new int[n];    //���࿡ �ϳ����� ��ġ�� �� �ֱ� ������ 1����, col[i]��°�濡 ������ ��ġ�� ������ �����Ѵ�.
		q.setQueens(0,col, n);		//������ ��ġ
		System.out.println(q.cnt);
	}
	
	public void setQueens(int i, int[] c, int n){
		if(checking(i, c)){            // col�迭�� i��° �࿡ ���� �� �� �ִ��� (�Ʒ� 26���ο��� col[i+1]=j; i���� ������ ����) ���� �������� �ʾҴٸ� �޼��� ����� ��� ����
			if(i==n-1) {				 // ���ȣ���� ��� ���������� �Դٸ� ����
				cnt++;
				//System.out.println(Arrays.toString(c));  /// ������ �ñ��ϸ� �ּ� Ǯ��~^^
			}
			else{
				int[] col=Arrays.copyOf(c, n);   // ���ȣ���̱� ������ �� ���ȣ���� ���� �����ϱ� ���� �迭 ����
				//int[] col=c.clone();   // ���ȣ���̱� ������ �� ���ȣ���� ���� �����ϱ� ���� �迭 ����
				for(int j=1; j<n;j++){	// i+1��° �࿡ �� ���� (1~n)���� �����Ͽ� 
					col[i+1]=j;
					setQueens(i+1, col, n); // ���� ���������� ��� ȣ��� üũ
				}
			}
		}
	}
	public boolean checking(int i, int[] col){
		boolean f=true;
		for(int k=1; k<i; k++){		// i��° �࿡ ������ ��ġ ���������� �׽�Ʈ �ϱ� ������ 1~i-1 ����� ������ üũ
			if(col[i] == col[k] || Math.abs(col[i]-col[k]) == i-k){//ol[i] == col[k]  ���� ������ üũ (���࿡ �ϳ��� ���ϱ� ������ ��üũ ���ʿ�)
					f=false;									//Math.abs(col[i]-col[k]) == i-k �밢�� üũ (�������̿� �ప���̰� ���ٸ� �밢��)
					break;
			}				
		}
		return f;
	}
}
