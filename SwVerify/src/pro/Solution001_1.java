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

package pro;
import java.io.FileInputStream;
import java.util.Scanner;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� �����
���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
class Solution001_1
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
			
			int[][] map = new int[MaxMap][MaxMap];
			/*
			�� �׽�Ʈ ���̽��� ǥ�� �Է¿��� �о�ɴϴ�.
			*/
			N = sc.nextInt(); 	// �۾����� ����

			int x = 0, y =0, e=0 ; // e �� �Ѻ��� ����
			int c[] = new int[N]; 			   // c �� ���� ��ȣ
			int workSu[] = new int[N+1]; // ������
			int tmpCnt = 0; // ����
			for (int i = 0; i < N; i++) {			
				for (int j = 0; j < 3; j++) {
					if (j == 0) x = sc.nextInt();
					else if (j == 1) y = sc.nextInt();
					else e = sc.nextInt();
				}
				c[i] = i + 1;
				// ���
				System.out.println("#"+test_case+"-" + c[i] + " " + x + " " + y + " " + e);
				
				for (int o=0; o < e; o++) {
					for (int p=0; p < e; p++) {
						if(x+o < MaxMap && y+p < MaxMap) {
							map[x+o][y+p] = c[i];
						}
					}
				}
			}
			
			// Map ���
//			for(int i = 0 ; i < MaxMap ; i++) {
//				for(int j = 0 ; j < MaxMap ; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.print('\n');
//			}

			// ����/ū ���� �����ȣ �� ���� ��ĵ
			for (int q=1; q <= N; q++) {
				for(int i = 0 ; i < MaxMap ; i++) {
					for(int j = 0 ; j < MaxMap ; j++) {
						if (map[i][j] == q) {
							tmpCnt ++;
						}
					}
				}
				workSu[q] = tmpCnt;
				//���
				System.out.print("�۾������� ���� : " + workSu[q] + "\n");
				tmpCnt = 0;
			}
			
			int min = workSu[1];
			int max = workSu[1];
			
			for (int q=2; q <= N; q++) {
				if (workSu[q] < min && workSu[q] > 0) min = workSu[q];
				if (workSu[q] > max) max = workSu[q];
			}
			
			String minStr = "";			
			String maxStr = "";
			int minCnt = 0;
			int maxCnt = 0;
			for (int q=1; q <= N; q++) {
				if (workSu[q] == min) {
					minStr = minStr + q + " " + min + " ";
					minCnt++;
				}
				if (workSu[q] == max) {
					maxStr = maxStr + q + " " + max + " ";
					maxCnt++;
				}
			}
			
			// output
			System.out.println("#"+test_case+" " + minCnt + " " + minStr);
			System.out.println(maxCnt + " " + maxStr);
		}
			
	}
}
