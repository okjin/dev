package day2.s2.string;


import java.util.Scanner;

public class Main1239 {
	public static String[][] alpha = { { "A", "000000" }, { "B", "001111" },
			{ "C", "010011" }, { "D", "011100" }, { "E", "100110" },
			{ "F", "101001" }, { "G", "110101" }, { "H", "111010" } };

	public static String getint(String i) {
		switch (i) {//완전히 일치하는경우를 우선 switch를 써서 잡아냅니다.
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
		int[] su = new int[8];//그 다음으로는  A만 1글자 차이나고 나머지는 2개이상차이나는경우가 있는지를 검색합니다.
		for (int j = 0; j < 8; j++) {//8문자 다 돌려주는데요
			for (int k = 0; k < 6; k++) {//각각 6자리를 검사합니다.
				if (i.charAt(k) != alpha[j][1].charAt(k)){
					su[j]++;//만약 다르면 카운트를 올립니다. 그러면 결국 다른글자의 갯수가 저장됩니다.
				}
			}
		}
		for (int j = 0; j < 8; j++) {
			int a = 0;//j번째 문자를 기준으로 잡습니다.
			for (int k = 0; k < 8; k++) {
				if (su[k] > 1&&k!=j){//전체를 검색하는데, 만약 k번째 문자의 틀린갯수가 2이상이고, k가 j가 아닌경우, "다르다"의 갯수를 올립니다.
					a++;
				}
			}
			if (a == 7 &&su[j]==1) {//만약 총 다르다의 갯수가 7개, 즉 해당 j번째 글자 외에 모든 글자가 2글자이상 다르고, j번째 문자는 1개만 다른경우, 해독가능하므로 해당 문자를 리턴
				return alpha[j][0];
			}
		}
		return "";//완전일치하지도 않고, 한글자만틀린글자도 없을경우, 혹은 여러개의문자에서 1개만 다른 경우 공백을 리턴합니다.

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();//첫줄에는 보낸 문자의 개수가 입력
		String[] ia = new String[n];//문자의 개수만큼 배열을 만들어줌
		String ss = s.next();//주어진 문자를 전체로 String으로 받아옴
		int a = 0;
		for (int i = 0; i < n; i++) {//주어진 문자는 6자리로 이루어져있으므로, 6으로 나눠 잘라줌
			ia[i] = ss.substring(a, a + 6);
			ia[i] = getint(ia[i]);
			a = a + 6;
		}
		String ans = "";//정답출력할 String 선언
		for (int i = 0; i < n; i++) {
			if (ia[i].equals("")) {//위의 매서드에서 에러가 난 경우  공백을 리턴하도록 되어있으므로, 만약 공백이 들어오면 해당 글자가 몇번째글자인지 출력하고 종료
				ans = (i + 1) + "";
				break;
			} else {//공백이 아닌경우에는 정답스트링에 계속해서 append
				ans = ans + ia[i];
			}
		}
		System.out.println(ans);
		s.close();
	}
}
