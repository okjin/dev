package day2.s2.string;


import java.util.Scanner;

public class Main1239 {
	public static String[][] alpha = { { "A", "000000" }, { "B", "001111" },
			{ "C", "010011" }, { "D", "011100" }, { "E", "100110" },
			{ "F", "101001" }, { "G", "110101" }, { "H", "111010" } };

	public static String getint(String i) {
		switch (i) {//������ ��ġ�ϴ°�츦 �켱 switch�� �Ἥ ��Ƴ��ϴ�.
		case "000000":
			return alpha[0][0];
		case "001111":
			return alpha[1][0];
		case "010011":
			return alpha[2][0];
		case "011100":
			return alpha[3][0];
		case "100110":
			return alpha[4][0];
		case "101001":
			return alpha[5][0];
		case "110101":
			return alpha[6][0];
		case "111010":
			return alpha[7][0];
		}
		int[] su = new int[8];//�� �������δ�  A�� 1���� ���̳��� �������� 2���̻����̳��°�찡 �ִ����� �˻��մϴ�.
		for (int j = 0; j < 8; j++) {//8���� �� �����ִµ���
			for (int k = 0; k < 6; k++) {//���� 6�ڸ��� �˻��մϴ�.
				if (i.charAt(k) != alpha[j][1].charAt(k)){
					su[j]++;//���� �ٸ��� ī��Ʈ�� �ø��ϴ�. �׷��� �ᱹ �ٸ������� ������ ����˴ϴ�.
				}
			}
		}
		for (int j = 0; j < 8; j++) {
			int a = 0;//j��° ���ڸ� �������� ����ϴ�.
			for (int k = 0; k < 8; k++) {
				if (su[k] > 1&&k!=j){//��ü�� �˻��ϴµ�, ���� k��° ������ Ʋ�������� 2�̻��̰�, k�� j�� �ƴѰ��, "�ٸ���"�� ������ �ø��ϴ�.
					a++;
				}
			}
			if (a == 7 &&su[j]==1) {//���� �� �ٸ����� ������ 7��, �� �ش� j��° ���� �ܿ� ��� ���ڰ� 2�����̻� �ٸ���, j��° ���ڴ� 1���� �ٸ����, �ص������ϹǷ� �ش� ���ڸ� ����
				return alpha[j][0];
			}
		}
		return "";//������ġ������ �ʰ�, �ѱ��ڸ�Ʋ�����ڵ� �������, Ȥ�� �������ǹ��ڿ��� 1���� �ٸ� ��� ������ �����մϴ�.

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();//ù�ٿ��� ���� ������ ������ �Է�
		String[] ia = new String[n];//������ ������ŭ �迭�� �������
		String ss = s.next();//�־��� ���ڸ� ��ü�� String���� �޾ƿ�
		int a = 0;
		for (int i = 0; i < n; i++) {//�־��� ���ڴ� 6�ڸ��� �̷���������Ƿ�, 6���� ���� �߶���
			ia[i] = ss.substring(a, a + 6);
			ia[i] = getint(ia[i]);
			a = a + 6;
		}
		String ans = "";//��������� String ����
		for (int i = 0; i < n; i++) {
			if (ia[i].equals("")) {//���� �ż��忡�� ������ �� ���  ������ �����ϵ��� �Ǿ������Ƿ�, ���� ������ ������ �ش� ���ڰ� ���°�������� ����ϰ� ����
				ans = (i + 1) + "";
				break;
			} else {//������ �ƴѰ�쿡�� ���佺Ʈ���� ����ؼ� append
				ans = ans + ia[i];
			}
		}
		System.out.println(ans);
		s.close();
	}
}
