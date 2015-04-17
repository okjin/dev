package day2.s4.assignment;

import java.util.ArrayList;
public class Chap1Ex3 {
	private ArrayList<String> answers;
	
     /*String[]�� ArrayList�� �����ϴ� �޼ҵ�
       ArrayList�� ���� ���� �����ϱ� ����...*/
	public ArrayList<String> stringToList(String[] arr){  
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0; i< arr.length; i++){
			list.add(arr[i]);
		}
		return list;
	}
     /* ArrayList�� �� ���� */
	public void setScore(ArrayList<String> ans){
		answers=ans;
	}
    /* ä���� ���� ���ϱ� */
	public double getScore(ArrayList<String> key){
		double score =0.0;
		for(int i=0; i< key.size(); i++){   //����� ������ŭ �ݺ�
			String an=answers.get(i);		//�л��� �ϳ��� ������
			if(an.equals(key.get(i)))		//�´��� Ȯ��
				score++;					// �´ٸ� score ����
			else if(!an.equals("?"))		// ?�� �ƴ϶�� score ����, ?�� �׳� �ݺ�
				score-=0.25;
		}
		return score;
	}
	/*
	public double getScore(ArrayList<String> key){
		int right =0;
		int wrong=0;
		for(int i=0; i< key.size(); i++){   //����� ������ŭ �ݺ�
			String an=answers.get(i);		//�л��� �ϳ��� ������
			if(an.equals(key.get(i)))		//�´��� Ȯ��
				right++;					// �´ٸ� right ����
			else if(!an.equals("?"))		// ?�� �ƴ϶�� wrong ���� , ?�� �׳� �ݺ�
				wrong++;
		}
		return (right*1)-(wrong*0.25);
	}
	*/

	public static void main(String[] args) 	{
		String[] key={"A","C","D","E","B","C","E","B","B","C"};
		String[] ans={"A","B","D","E","A","C","?","B","D","C"};
		Chap1Ex3 s=new Chap1Ex3();
		//�迭�� ��� �л������ ArrayList�� �����Ͽ� ����
		s.setScore(	s.stringToList(ans));	
		//�迭�� ��� ������ ArrayList�� �����Ͽ� ���� ä�� �޼ҵ� ȣ��
		System.out.println(s.getScore(s.stringToList(key)));
	}
}
