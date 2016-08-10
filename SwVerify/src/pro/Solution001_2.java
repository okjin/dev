/*
 * ����: (��) [16�� 8�� Professional ���� �����׽�Ʈ] ��ĥ�ϱ� 
 * [����]
       ��ǰ�� ��ȣ�ϰų� �������� �����̵��� �κ��̳� �����ġ�� �̿��� ��ĥ�ϴ� �۾��� ���� �� ���������� �ڵ�ȭ�Ǿ� ���� �ִ�. 
       �Ϲ������� ��ĥ�ϴ� �۾��� �ϼ����� �۾� ������ �ſ� �ΰ��ϴ�. 
       �۾��� ������ ������ �ٲ㰡�鼭 ���ϴ� �κи� �����Ӱ� ��ĥ�� �� �ִ� �κ��� �۾� ������ ������ �ִ��� ������ �̸� �˻��ϱ� ���� ���α׷��� �����Ϸ��� �Ѵ�. 
       �κ��� ��ĥ�� �۾� ������ ���簢���� ���� �Ʒ��� �ִ� �������� ��ǥ (x,y)�� �� ���� ���� s�� ���Ͽ� (x,y,s)�� �����ϸ�, 
       �κ��� �۾� ����� �۾� ������ �۾� ������ ���� ���ʴ�� �����ϸ� �ȴ�. 
       ���� ��� �۾���� (1,1,2), (2,2,4), (3,4,1), (7,2,1) ������ ����� �Ʒ� ���� �׸��� ����. 
       ������ �۾��̶� �۾� ������ �ݴ�� �ٲ� �۾���� (7,2,1), (3,4,1), (2,2,4), (1,1,2)�� ������ ����� 
       �Ʒ� ������ �׸��� ������, �� ��° �۾��� (3,4,1) ������ �� ��° �۾��� (2,2,4)�� ���� ������ ���� ������� ��쵵 �߻��� �� �ִ�. 
       �� ��, ���������� ĥ���� �۾� ������ ũ��� ���ο� ���ΰ� ���� 1�� ���簢���� ������ ��Ÿ����.
       
[�������]
   �۾������� ��Ÿ���� x, y, s�� 1�� 10,000 ������ �����̸�, �ϳ��� �۾���ɿ� ���Ե� �� �ִ� �۾������� �ִ� 100�� �̳��� �����Ѵ�. 

[�Է�]
   ������ ù° �ٿ� ���̽��� ���� T�� �־�����, ���� ���ʷ� T�� �׽�Ʈ ���̽��� �־�����. �� �׽�Ʈ ���̽��� ù �ٿ� �ϳ��� �۾� ��ɿ� ���Ե� �۾� ������ ������ �־����� ��° �ٿ��� ��� �۾� ������ �۾� ������� �־�����.

[���]
   �� �׽�Ʈ ���̽��� ���Ͽ� �˻��� ����� ���̽����� �� �پ� ����Ѵ�. ù ���� '#x'�� �����ϰ� �����ϳ��� �� ���� ���� ���� ������ ������ �ش� ������ ����� ũ�⸦ �־��� ������� ����ϰ�, ���� �ٿ��� ���� ū ������ ������ �ش� ������ ����� ũ�⸦ �־��� ������� ����Ѵ�.
 */

/* Ǯ�� ����
 * �۾������� ���� 1�� �迭 ����, ���� ũ�⸸ŭ
 */
package pro;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� �����
���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
class Solution001_2
{
	static int N = 0;
	static int MaxMap = 10000;

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("sample_input_001-1.txt"));

		Scanner sc = new Scanner(System.in);
		int T;	// �׽�Ʈ���̽� ����
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			/*
			�� �׽�Ʈ ���̽��� ǥ�� �Է¿��� �о�ɴϴ�.
			*/
			N = sc.nextInt(); 	// �۾����� ����

			int x = 0, y =0, e=0 ; // e �� �Ѻ��� ����
			Vector v = new Vector();
			List<String> list;
			
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < 3; j++) {
					if (j == 0) x = sc.nextInt();
					else if (j == 1) y = sc.nextInt();
					else e = sc.nextInt();
				}
				// ���
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
			
			// Map ���
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
