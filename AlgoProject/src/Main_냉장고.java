import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_≥√¿Â∞Ì {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int matter[][] = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			matter[i][0] = sc.nextInt();
			matter[i][1] = sc.nextInt();
		}
		
		Arrays.sort(matter, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] - o2[0] == 0) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		int current = matter[0][1];
		int count = 1;
		for(int i = 1; i < N ; i++) {
			if(current < matter[i][0]) {
				count++;
				current = matter[i][1];
			} else {
				if(current > matter[i][1]) {
					current = matter[i][1];
				}
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}
}
