package day1.s3.stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class StackEx1 {
	public static void main(String[] args) {
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(new Integer(10));
		l.add(new Integer(20));
		System.out.println(l);
		System.out.println(l.remove(10));
		System.out.println(l.remove(10));
	}
}
