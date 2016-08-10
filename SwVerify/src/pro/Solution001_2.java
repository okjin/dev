/*
 * 문제: (중) [16년 8월 Professional 검정 사전테스트] 색칠하기 
 * [문제]
       제품을 보호하거나 디자인이 돋보이도록 로봇이나 기계장치를 이용해 색칠하는 작업이 점점 더 정밀해지고 자동화되어 가고 있다. 
       일반적으로 색칠하는 작업의 완성도는 작업 순서에 매우 민감하다. 
       작업할 때마다 색깔을 바꿔가면서 원하는 부분만 자유롭게 색칠할 수 있는 로봇의 작업 순서에 오류가 있는지 사전에 미리 검사하기 위한 프로그램을 개발하려고 한다. 
       로봇이 색칠할 작업 영역을 정사각형의 왼쪽 아래에 있는 꼭지점의 좌표 (x,y)와 한 변의 길이 s를 합하여 (x,y,s)로 정의하면, 
       로봇의 작업 명령은 작업 영역을 작업 순서에 따라 차례대로 나열하면 된다. 
       예를 들어 작업명령 (1,1,2), (2,2,4), (3,4,1), (7,2,1) 실행한 결과는 아래 왼쪽 그림과 같다. 
       동일한 작업이라도 작업 순서를 반대로 바꾼 작업명령 (7,2,1), (3,4,1), (2,2,4), (1,1,2)을 실행한 결과는 
       아래 오른쪽 그림과 같으며, 두 번째 작업한 (3,4,1) 영역이 세 번째 작업한 (2,2,4)에 의해 완전히 덮여 사라지는 경우도 발생할 수 있다. 
       이 때, 최종적으로 칠해진 작업 영역의 크기는 가로와 세로가 각각 1인 정사각형의 개수로 나타낸다.
       
[제약사항]
   작업영역을 나타내는 x, y, s는 1과 10,000 사이의 정수이며, 하나의 작업명령에 포함될 수 있는 작업영역은 최대 100개 이내로 제한한다. 

[입력]
   파일의 첫째 줄에 케이스의 개수 T가 주어지고, 이후 차례로 T개 테스트 케이스가 주어진다. 각 테스트 케이스는 첫 줄에 하나의 작업 명령에 포함된 작업 영역의 개수가 주어지고 둘째 줄에는 모든 작업 영역이 작업 순서대로 주어진다.

[출력]
   각 테스트 케이스에 대하여 검사한 결과를 케이스별로 두 줄씩 출력한다. 첫 줄은 '#x'로 시작하고 공백하나를 둔 다음 가장 작은 영역의 개수와 해당 영역의 색깔과 크기를 주어진 순서대로 출력하고, 다음 줄에는 가장 큰 영역의 개수와 해당 영역의 색깔과 크기를 주어진 순서대로 출력한다.
 */

/* 풀이 전략
 * 작업영역별 동적 1차 배열 생성, 색깔 크기만큼
 */
package pro;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할
것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution001_2
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
			List<String> list;
			
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < 3; j++) {
					if (j == 0) x = sc.nextInt();
					else if (j == 1) y = sc.nextInt();
					else e = sc.nextInt();
				}
				// 출력
//				System.out.println("#"+test_case+"-" + i+1 + " " + x + " " + y + " " + e);
				list = new ArrayList();
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
				Collections.addAll(list, array);
                v.add(list);
			}
			
			// Map 출력
//			for(int i = 0 ; i < v.size() ; i++) {
//				List<String> tmpList = (List<String>) v.get(i);
//				System.out.println(tmpList.size() + " : " + tmpList.toString());
//			}
			
			Vector<List<String>> tmpV = new Vector<List<String>>();
			for (int o=1; o < v.size(); o++) {
				
				List<String> curList = (List<String>) v.get(o);
				tmpV = new Vector<List<String>>();
				for (int p=0; p < o; p++) {
					List<String> preList = (List<String>) v.get(p);		
					
					for (int q=0; q < curList.size(); q++) {
						preList.remove(curList.get(q));
					}
					tmpV.add(preList);
				}
				tmpV.add(curList);

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
