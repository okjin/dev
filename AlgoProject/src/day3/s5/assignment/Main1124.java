package day3.s5.assignment;

import java.util.Scanner;

public class Main1124 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] pa = new int[101][101];
		int x,y;

		for(int i=0; i<n; i++){
			x = s.nextInt();
			y = s.nextInt();
			
			for(int j=0; j<10; j++){
				for(int k=0; k<10; k++)
					pa[x+j][y+k] = 1;
			}
		}
		
		int max=0;
		int r = 0, maxrow = 0;
		
		for(int i=1; i<101; i++){
			for(int j=1; j<=101-i; j++){
				r = 0;
				maxrow = 0;
				
				if(j==101-i){
					if(r > maxrow) maxrow = r;
					r = 0;
					break;
				}
				
				for(int k=1; k<101; k++){
					for(int l=0; l<=i; l++){
						if(l==i){
							r++;
						}
						else if(pa[j+l][k] == 0){
							if(r > maxrow) maxrow = r;
							r = 0;
							break;
						}
					}
				}
				if((i * maxrow) > max) max = i * maxrow;
			}
			if((i * maxrow) > max) max = i * maxrow;
		}
		System.out.println(max);
	}
}
