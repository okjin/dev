/*
 * 최대 힙
 * https://www.acmicpc.net/problem/11279
 */

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;


class Solution_MaxHip
{ 
	static int ArraySize = 100001;
	static int queueArray[] = new int[ArraySize];
	static int idx = 0;
	static int firstIdx = 1;

	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("sample_maxhip_002.txt"));
		Scanner sc = new Scanner(System.in);
		int T;	// 테스트케이스 갯수 (이문제에서는 입력값 갯수)
		T = sc.nextInt();


		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int inValue = sc.nextInt();
			
//			System.out.println(inValue);
			if (inValue > 0) {
				setValue(inValue);
			}
			else if (inValue == 0) {
				System.out.println(getValue());
			}
		}
			
	} // main

	
	private static int getValue() {
		int r;
		
		if (idx == 0) {
			r = 0;
		}
		else {
			r = queueArray[firstIdx];
			
			for (int i = firstIdx; i < idx; i++) {
				if (queueArray[i*2] > queueArray[i*2+1]) {
					queueArray[i] = queueArray[i*2];
				}
				else {
					queueArray[i] = queueArray[i*2+1];
				}
			}
//			queueArray[idx] = 0;
			idx--;
		}
		
		return r;
	}
	
	private static void setValue(int a) {
		int t;
		queueArray[++idx] = a;

		for (int i = idx; i > 1; i--) {
			if (queueArray[i] > queueArray[i/2]) {
				t = queueArray[i/2];
				queueArray[i/2] = queueArray[i];
				queueArray[i] = t;
			}
		}
	}
	
//	private static int getArraySize(int[] a) {
//		int i;
//		for (i=1; i < a.length; i++) {
//			if (a[i] == 0) break;
//		}
//		return i;
//	}
//	
//	private static void printArray(int[] a) {
//		for (int i=1; i < getArraySize(a); i++) {
//			System.out.println(a[i]);
//		}
//	}
}
