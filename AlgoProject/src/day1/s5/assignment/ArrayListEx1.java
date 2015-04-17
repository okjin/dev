package day1.s5.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListEx1 {
	public static void main(String[] args) {
		        //01234567890123456789012345//
		String s="ABCDEDGHIJKLMNOPQRSTUVWXYZ";
		
		String s1=""+1;
		String s2=String.valueOf(1);
		String s3=new Integer(1).toString();
		
		System.out.println(s.charAt(3));
		System.out.println(s.substring(3,3+6));
		System.out.println(s.substring(3));
		System.out.println(s.indexOf("D"));
		System.out.println(s.indexOf("D", 4));
		System.out.println(s.startsWith("ABC"));
		System.out.println(s.startsWith("BC"));		
	}
}
