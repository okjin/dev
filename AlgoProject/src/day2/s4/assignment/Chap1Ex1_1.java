package day2.s4.assignment;

public class Chap1Ex1_1 {

	int[] eng={96,71,100,65,97,80,90,56,70,100};
	int[] math={90,89,95,80,45,89,89,94,55,100};
	
	public int getMaxMath(){
		int max=0;
		for(int i=0; i<eng.length; i++){
			if(eng[i]==100){
				if(math[i]>max){
					max=math[i];
				}
			}
		}
		return max;
	}
	public int getCount(int start, int end){
		int count=0;
		for(int i=0; i<eng.length; i++){
			if(eng[i]>=start && eng[i]<end){
				count++;
			}
		}
		return count;
	}
	public int getAvgEng(){
		int sum=0;
		for(int i=0; i<eng.length; i++){
			sum+=eng[i];
		}
		return sum/eng.length;
	}
	public int getAvgMath(){
		int sum=0;
		int count=0;
		for(int i=0; i<eng.length; i++){
			if(eng[i]==100){
				sum+=math[i];
				count++;
			}
		}
		return sum/count;
	}
	public static void main(String[] args) {
		Chap1Ex1_1 p=new Chap1Ex1_1();
		System.out.println("영어만점자 중 수학고득점 : "+p.getMaxMath());
		System.out.println("영어성적 70~90점  : "+p.getCount(70,90));
		System.out.println("영어성적 평균  : "+p.getAvgEng());
		System.out.println("영어만점자들의 수학 평균  : "+p.getAvgMath());

	}

}
