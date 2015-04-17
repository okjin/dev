package day2.s4.assignment;

public class Chap1Ex2 {

	public static void main(String[] args) {
		int[] tel={5000,3000,200,45000,6000,150,5000,33000,5400,6000};
		int total=0;
		for(int t: tel){
			if(t>200){
				total+=t;
			}			
		}
		System.out.println("총 통화 시간 :"+total);
		System.out.println("일일 평균 통화 시간 :"+total/tel.length);
	}
}
