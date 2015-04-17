package day4.s3.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1060 {
	public static void main(String[] args) {
		Scanner s=new Scanner( System.in );
		int N=Integer.parseInt( s.nextLine() );
		int[][] node=new int[N][N];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				node[i][j]=s.nextInt();
			}
		}
		s.close();
		
		List<Integer> cn=new ArrayList<Integer>();
		cn.add(0);
		
		long sum=0;
		while(cn.size()<N){
			long min=Integer.MAX_VALUE;
			int select=-1;
			for(int i=0; i<cn.size(); i++){
				for(int j=0; j<node[i].length; j++){
					boolean check=false;
					for(Integer nodeno:cn){
						if(j==nodeno){
							check = true;
							break;
						}
					}
					if(check){
						continue;
					}
					if(min>node[cn.get(i)][j]){
						min=node[cn.get(i)][j];
						select = j;
					}
				}
			}
			cn.add(select);
			sum+=min;
		}
		System.out.println(sum);
	}
}


/*


입력예
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0



출력예
10


*/















