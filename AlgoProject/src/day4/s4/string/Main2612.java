package day4.s4.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2612 {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().trim().split(" "); // 프로그램 수
		int n = Integer.parseInt(nk[0]); // 코드 수
		int k = Integer.parseInt(nk[1]); // 추정 코드 길이
		String[][] program = new String[n][];

		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine().trim()); // 전체 코드 길이

			// 추정 코드길이가 전체 코드길이 보다 길면, 바이러스 없음
			if (k > m) {
				System.out.println("NO");
				System.exit(0);
			}
			// //////////////////////////////////////

			program[i] = br.readLine().trim().split(" ");
		}
		br.close();

		// 처리
		int count=0;
		boolean check=false;
		for (int i = 1; i < program.length; i++) {
			check=false;
			count=0;
			for (int j = 0; j < program[0].length-k; j++) {
				if(check){
					break;
				}

				for (int l = 0; l < program[i].length; l++) {
					if(check){
						break;
					}
					
					if (!program[0][j].equals(program[i][l])) { // 같은 수를 못찾으면 뒷 숫자와 다시 비교
						continue;
					} else {
						for(int a=j, b=l; a<j+k; a++, b++){ // 뒤로 비교
							if(a<program[0].length && b<program[i].length){
								if(!program[0][a].equals(program[i][b])){
									check=false;
									count=0;
									break;
								}else{
									count++;
									if(count==k){
										check = true; break;
									}
								}
							}else{
								check=false;
								count=0;
								break;
							}
						}
						if(count>=k && i==program.length-1){
							System.out.println("YES");
							System.exit(0);
						}else{
							if(check) break;
						}
						
						count=0;
						for(int a=j, b=l; a<j+k; a++, b--){ // 앞으로 비교
							if(a<program[0].length && b>=0){
								if(!program[0][a].equals(program[i][b])){
									check=false;
									count=0;
									break;
								}else{
									count++;
									if(count==k){
										check = true; break;
									}
								}
							}else{
								check=false;
								count=0;
								break;
							}
						}
						if(count>=k && i==program.length-1){
							System.out.println("YES");
							System.exit(0);
						}else{
							if(check) break;
						}
					}
				}
				if(j==program[0].length-k-1){
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		System.out.println("NO");
	}
}
