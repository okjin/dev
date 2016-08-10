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
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� �����
���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
class Solution001_3
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
			String work[] = new String[N]; // �۾����� ��ǥ�� ���Ǳ���
			int workCnt[] = new int[N];    // �۾����� ũ��
			
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < 3; j++) {
					if (j == 0) x = sc.nextInt();
					else if (j == 1) y = sc.nextInt();
					else e = sc.nextInt();
				}
				// �Ʒ� ó�� ũ�� ��� �Ҷ����� MaxMap ����ؼ� ��� �ؾ� ��!!!
				workCnt[i] = e * e;
				// ���
//				System.out.println("#"+test_case+"- " + i+1 + " " + x + " " + y + " " + e);
				work[i] = x + "/" + y + "/" + e;
				System.out.println("#"+test_case+" - " + i + " : " + work[i]);
								
				for (int o=0; o < i; o++) {
					String [] preValue = work[o].split("/");
					int preX = 0, preY = 0, preE = 0;
					preX = Integer.parseInt(preValue[0]);
					preY = Integer.parseInt(preValue[1]);
					preE = Integer.parseInt(preValue[2]);
					
					int tmpGap = 0, gap = 0;
					
					if ( x+e <= preX) {
						gap = 0;
					}
					else if (x < preX) {
						tmpGap = ((x + e) - preX) * ((y + e) - preY);
	
						if (tmpGap < 0) gap = 0;
						else if (tmpGap > (e*e)) gap = e*e;
						else gap = tmpGap;
					}
					else {
						tmpGap = ((preX + preE) - x) * ((preY + preE) - y);
	
						if (tmpGap < 0) gap = 0;
						else if (tmpGap > (e*e)) gap = e*e;
						else gap = tmpGap;
					}
					
					if ((workCnt[o] - gap) < 0) workCnt[o] = 0;
					else workCnt[o] = workCnt[o] - gap;
					
					System.out.println("pre workCnt[" + o + "] : " + workCnt[o]);				

				}
				
			}
			
			for (int i = 0; i < N; i++) {
				System.out.println("#"+test_case+" - " + i + " workCnt : "  + workCnt[i]);	
			}
			
//	
//			
//
//			/*
//			 * �ּ�, �ִ밪 ���ϱ�
//			 */
//			int min = ((Vector) v.get(0)).size();
//			int max = ((Vector) v.get(0)).size();
//			
//			for (int i=1; i < v.size(); i++) {
//				if (((Vector) v.get(i)).size() < min && ((Vector) v.get(i)).size() > 0) min = ((Vector) v.get(i)).size();
//				if (((Vector) v.get(i)).size() > max) max = ((Vector) v.get(i)).size();
//			}
//			
//			System.out.println("min : " + min + " , " + "max : " + max);
//
//			/*
//			 * ���� ���� ������ ������ �ش� ������ ����
//			 * ���� ū ������ ������ �ش� ������ ����
//			 */
//			int minCnt = 0;
//			int maxCnt = 0;
//			String minStr = "";			
//			String maxStr = "";
//			
//			for(int i = 0 ; i < v.size() ; i++) {
//				List<String> tmpList = (List<String>) v.get(i);
//				if (tmpList.size() == min) {
//					minStr = minStr + (i+1) + " " + min + " ";
//					minCnt++;
//				}
//				if (tmpList.size() == max) {
//					maxStr = maxStr + (i+1) + " " + max + " ";
//					maxCnt++;
//				}
//			}
			
			// output
			/* �� �׽�Ʈ ���̽��� ���Ͽ� �˻��� ����� ���̽����� �� �پ� ����Ѵ�. 
			 * ù ���� '#x'�� �����ϰ� �����ϳ��� �� ���� ���� ���� ������ ������ �ش� ������ ����� ũ�⸦ �־��� ������� ����ϰ�, 
			 * ���� �ٿ��� ���� ū ������ ������ �ش� ������ ����� ũ�⸦ �־��� ������� ����Ѵ�.
			 */
//			System.out.println("#"+test_case+" " + minCnt + " " + minStr);
//			System.out.println(maxCnt + " " + maxStr);
		}
			
	} // main
	
//	private boolean isCover(String preStr, String CurStr) {
//		
//		
//		
//		return false;
//	}
}
