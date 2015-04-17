package day1.s3.stack;

import java.util.Stack;

public class MyStackExam1 {
	public static void main(String[] args) {
		String st="(5+(7*8))";// 578*+
		//String st="((5+7)*8)";// 57+8*
		Stack<Character> s=new Stack<Character>();
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<st.length(); i++){
			char c=st.charAt(i);
			if(Character.isDigit(c)){
				sb.append(c);
			}else if(c==')'){
				sb.append(s.pop());
			}else if(c=='+'||c=='-'||c=='*'||c=='/'){
				s.push(c);
			}
		}
		System.out.println(sb);
	}
}
