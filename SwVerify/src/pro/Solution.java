package pro;

import java.io.FileInputStream;
import java.util.ArrayList;
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
						preArray.remove(curArray.get(q));
					}
					tmpV.add(preArray);
				}
				tmpV.add(curArray);

			}
			v = tmpV;

			List list1 = (List) v.get(0);
			int min = list1.size();
			int max = list1.size();
			
			for (int i=1; i < v.size(); i++) {
				List list2 = (List) v.get(i);
				
				if (list2.size() < min && list2.size() > 0) min = list2.size();
				if (list2.size() > max) max = list2.size();
				
//				if (((Vector) v.get(i)).size() < min && ((Vector) v.get(i)).size() > 0) min = ((Vector) v.get(i)).size();
//				if (((Vector) v.get(i)).size() > max) max = ((Vector) v.get(i)).size();
			}

			int minCnt = 0;
			int maxCnt = 0;
			String minStr = "";			
			String maxStr = "";
			
			for(int i = 0 ; i < v.size() ; i++) {
				List<String> tmpList = (List<String>) v.get(i);
				if (tmpList.size() == min) {
					minStr = minStr + (i+1) + " " + min + " ";
					minCnt++;
				}
				if (tmpList.size() == max) {
					maxStr = maxStr + (i+1) + " " + max + " ";
					maxCnt++;
				}
			}

			System.out.println("#"+test_case+" " + minCnt + " " + minStr);
			System.out.println(maxCnt + " " + maxStr);
		}
			
	} // main

}
