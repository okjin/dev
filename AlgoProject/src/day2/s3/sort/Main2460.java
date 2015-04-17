package day2.s3.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main2460 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		Candidate c1=new Candidate(1);
		Candidate c2=new Candidate(2);
		Candidate c3=new Candidate(3);
		for(int i=0; i<n; i++){
			c1.set(s.nextInt());
			c2.set(s.nextInt());
			c3.set(s.nextInt());
		}
		Candidate[] ca={c1,c2,c3};
		Arrays.sort(ca);
		if(ca[0].compareTo(ca[1])==0){
			System.out.println("0 "+ca[0].sum());
		}else{
			System.out.println(ca[0].num+" "+ca[0].sum());
		}
		s.close();
	}
	static class Candidate implements Comparable<Candidate>{
		int num;
		int[] j=new int[3];
		
		Candidate(int num){
			this.num=num;
		}
		public void set(int i){
			j[i-1]++;
		}
		public int sum(){
			return j[0]*1+j[1]*2+j[2]*3;
		}
		@Override
		public int compareTo(Candidate o) {
			int re= o.sum()-sum();
			if(re==0){
				re=o.j[2]-j[2];
				if(re==0){
					return o.j[1]-j[1];
				}
			}
			return re;
		} 
	}
}
