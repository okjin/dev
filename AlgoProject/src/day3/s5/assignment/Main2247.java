package day3.s5.assignment;


import java.util.Scanner;

public class Main2247 {
//������
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int set = sc.nextInt();
		int [] start = new int [set];
		int [] end = new int [set];
		
		for(int i=0; i<set; i++){
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
		}
		sc.close();
		
		//���۽ð� ���� �����Ʈ
		int temp = 0;		
		for(int i=0; i<set-1; i++){
			for(int j=0; j<set-1-i; j++){
				if(start[j] > start[j+1]){
					temp = start[j];
					start[j] = start[j+1];
					start[j+1] = temp;
					
					temp = end[j];
					end[j] = end[j+1];
					end[j+1] = temp;
				}
			}
		}
		//��
		int curStart = start[0];
		int curEnd = end[0];
		int maxFull = 0;
		int maxEmpty = 0;
		
		for(int i=1; i<set; i++){
			if(curEnd >= start[i]){  //���� �л��� �����ִ� ���� �ٸ� �л��� �°�
				curEnd = curEnd > end[i] ? curEnd : end[i];
			}else{
				int full = curEnd - curStart;				
				maxFull = maxFull > full ? maxFull : full;
				
				int empty = start[i] - curEnd;				
				maxEmpty = maxEmpty > empty ? maxEmpty : empty;
				
				curStart = start[i];
				curEnd = end[i];
			}
		}
		//������ �����Ϳ� ���� �ð� üũ
		int last = curEnd - curStart;
		maxFull = maxFull > last ? maxFull : last;
		
		System.out.println(maxFull + " " + maxEmpty);
	}
}
