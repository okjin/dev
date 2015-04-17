package day2.s4.assignment;

import java.util.ArrayList;
public class Chap1Ex3 {
	private ArrayList<String> answers;
	
     /*String[]을 ArrayList로 변경하는 메소드
       ArrayList에 값을 쉽게 저장하기 위해...*/
	public ArrayList<String> stringToList(String[] arr){  
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0; i< arr.length; i++){
			list.add(arr[i]);
		}
		return list;
	}
     /* ArrayList에 값 저장 */
	public void setScore(ArrayList<String> ans){
		answers=ans;
	}
    /* 채점과 점수 구하기 */
	public double getScore(ArrayList<String> key){
		double score =0.0;
		for(int i=0; i< key.size(); i++){   //답안의 갯수만큼 반복
			String an=answers.get(i);		//학생답 하나를 꺼내서
			if(an.equals(key.get(i)))		//맞는지 확인
				score++;					// 맞다면 score 증가
			else if(!an.equals("?"))		// ?가 아니라면 score 감소, ?면 그냥 반복
				score-=0.25;
		}
		return score;
	}
	/*
	public double getScore(ArrayList<String> key){
		int right =0;
		int wrong=0;
		for(int i=0; i< key.size(); i++){   //답안의 갯수만큼 반복
			String an=answers.get(i);		//학생답 하나를 꺼내서
			if(an.equals(key.get(i)))		//맞는지 확인
				right++;					// 맞다면 right 증가
			else if(!an.equals("?"))		// ?가 아니라면 wrong 증가 , ?면 그냥 반복
				wrong++;
		}
		return (right*1)-(wrong*0.25);
	}
	*/

	public static void main(String[] args) 	{
		String[] key={"A","C","D","E","B","C","E","B","B","C"};
		String[] ans={"A","B","D","E","A","C","?","B","D","C"};
		Chap1Ex3 s=new Chap1Ex3();
		//배열에 담긴 학생답안을 ArrayList로 변경하여 저장
		s.setScore(	s.stringToList(ans));	
		//배열에 담긴 정답을 ArrayList로 변경하여 점수 채점 메소드 호출
		System.out.println(s.getScore(s.stringToList(key)));
	}
}
