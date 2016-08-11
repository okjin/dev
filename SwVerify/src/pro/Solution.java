package pro;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


class Solution
{
	static int N = 0;
	static int MaxMap = 10000;

	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("sample_input_001-1.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T;	// 테스트케이스 갯수
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			/*
			각 테스트 케이스를 표준 입력에서 읽어옵니다.
			*/
			N = sc.nextInt(); 	// 작업영역 갯수

			int x = 0, y =0, e=0 ; // e 는 한변의 길이
			Vector v = new Vector();
			
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < 3; j++) {
					if (j == 0) x = sc.nextInt();
					else if (j == 1) y = sc.nextInt();
					else e = sc.nextInt();
				}
				// 출력
//				System.out.println("#"+test_case+"-" + i+1 + " " + x + " " + y + " " + e);

				String tmpStr = "";
				for (int o=0; o < e; o++) {
					for (int p=0; p < e; p++) {
						if(x+o < MaxMap && y+p < MaxMap) {
//							list.add(Integer.toString(x+o) + "/" + Integer.toString(y+p));
							tmpStr = tmpStr + Integer.toString(x+o) + "/" + Integer.toString(y+p) + ",";
						}
					}
				}
				String[] array = tmpStr.split(",");
                v.add(array);
			}
			
			// Map 출력
//			for(int i = 0 ; i < v.size() ; i++) {
//				List<String> tmpList = (List<String>) v.get(i);
//				System.out.println(tmpList.size() + " : " + tmpList.toString());
//			}
			
			Vector<String[]> tmpV = new Vector<String[]>();
			for (int o=1; o < v.size(); o++) {
				
				String[] curArray = (String[]) v.get(o);
				tmpV = new Vector<String[]>();
				for (int p=0; p < o; p++) {
					String[] preArray = (String[]) v.get(p);		
					
					for (int q=0; q < curArray.length; q++) {
						find(preArray, curArray[q]);
					}
					tmpV.add(reSet(preArray));
				}
				tmpV.add(curArray);

			}
			v = tmpV;

			String[] list1 = (String[]) v.get(0);
			int min = list1.length;
			int max = list1.length;
			
			for (int i=1; i < v.size(); i++) {
				String[] list2 = (String[]) v.get(i);
				
				if (list2.length < min && list2.length > 0) min = list2.length;
				if (list2.length > max) max = list2.length;
			}

			int minCnt = 0;
			int maxCnt = 0;
			String minStr = "";			
			String maxStr = "";
			
			for(int i = 0 ; i < v.size() ; i++) {
				String[] tmpList = (String[]) v.get(i);
				if (tmpList.length == min) {
					minStr = minStr + (i+1) + " " + min + " ";
					minCnt++;
				}
				if (tmpList.length == max) {
					maxStr = maxStr + (i+1) + " " + max + " ";
					maxCnt++;
				}
			}

			System.out.println("#"+test_case+" " + minCnt + " " + minStr);
			System.out.println(maxCnt + " " + maxStr);
		}
			
	} // main

	private static String[] reSet(String[] preArray) {
		
		String str = "";
		for (int i=0; i < preArray.length; i++) {
			if (!preArray[i].equals("")) {
				str = str + preArray[i] + ",";
			}
		}
		
		return str.split(",");
	}

	private static void find(String[] preArray, String string) {
		
		for (int i=0; i < preArray.length; i++) {
			if (preArray[i].indexOf(string) >= 0) {
				preArray[i] = "";
				return ;
			}
		}
	}

}
