package day1.s3.stack;

import java.util.Stack;

public class MyStackExam2 {
	public static void main(String[] args) {
		String st="578*+";
		Stack<Integer> s=new Stack<Integer>();
		for(int i=0; i<st.length(); i++){
			char c=st.charAt(i);
			if(Character.isDigit(c)){
				s.push(c-'0');
			}else {
				switch(c){
					case '+': s.push(s.pop()+s.pop()); break;
					case '-': s.push(s.pop()-s.pop()); break;
					case '*': s.push(s.pop()*s.pop()); break;
					case '/': s.push(s.pop()/s.pop()); break;
				}
			}
		}
		System.out.println(s.pop());
	}
}
