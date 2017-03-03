/*
 * 큐
 * https://www.acmicpc.net/problem/10845
 */

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;


class Solution_queue
{
	static int ArraySize = 10001;

	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("sample_queue_001.txt"));
		Scanner sc = new Scanner(System.in);
		int T;	// 테스트케이스 갯수 (이문제에서는 명령어 갯수)
		T = sc.nextInt();

		int queueArray[] = new int[ArraySize];
		int idx = -1;
		int firstIdx = 0;
		
//		String tmp = sc.nextLine();
		for(int test_case = 0; test_case <= T; test_case++)
		{
			String str = sc.nextLine();
			
//			System.out.println(str);
			
			if (str.isEmpty()) {
				continue;
			} 
			else if (getCommand(str).equals("push")) {
				queueArray[++idx] = new Integer(getValue(str));
			}
			else if (getCommand(str).equals("pop")) {
				if (idx < 0) {
					System.out.println("-1");
				} else {
					System.out.println(queueArray[firstIdx]);
//					System.out.println("--------------");
//					printArray(queueArray);
//					System.out.println("--------------");
					
					if (idx >= 0) {
						int i = 0;
						int arrSize = getArraySize(queueArray);
						for (i = 0; i < arrSize; i++) {
							if (i == arrSize-1) {
								queueArray[i] = 0;
							} else {
								queueArray[i] = queueArray[i+1];
							}
						}
					}
					idx--;
					
//					System.out.println("after --------------");
//					printArray(queueArray);
//					System.out.println("-------------- after");
				}
			}
			else if (getCommand(str).equals("size")) {
				System.out.println(getArraySize(queueArray));
			}
			else if (getCommand(str).equals("empty")) {
//				System.out.println("quesize : " + getArraySize(queueArray));
				if (getArraySize(queueArray) == 0) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			}
			else if (getCommand(str).equals("front")) {
				if (getArraySize(queueArray) == 0) {
					System.out.println("-1");
				}
				else {
					System.out.println(queueArray[firstIdx]);
				}
			}
			else if (getCommand(str).equals("back")) {
				if (getArraySize(queueArray) == 0) {
					System.out.println("-1");
				}
				else {
					System.out.println(queueArray[idx]);
				}
			}
			

//			System.out.println(str);
//			System.out.println(getCommand(str));
//			System.out.println(getValue(str));
		}
			
	} // main
	
	private static String getCommand(String str) {
		if (!str.isEmpty() && str.indexOf(" ") > 0) {
			StringTokenizer st = new StringTokenizer(str, " ");
			return st.nextToken();
		} else {
			return str.trim();
		}		
	}

	private static String getValue(String str) {
		if (!str.isEmpty() && str.indexOf(" ") > 0) {
			StringTokenizer st = new StringTokenizer(str, " ");
			st.nextToken();
			return st.nextToken();
		} else {
			return str.trim();
		}		
	}
	
	private static int getArraySize(int[] a) {
		int i = 0;
		for (i=0; i < a.length; i++) {
			if (a[i] == 0) break;
		}
		
		return i;
	}
	
	private static void printArray(int[] a) {
		for (int i=0; i < getArraySize(a); i++) {
			System.out.println(a[i]);
		}
	}
}
