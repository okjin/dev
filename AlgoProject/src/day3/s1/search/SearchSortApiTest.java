package day3.s1.search;

import java.util.Arrays;

public class SearchSortApiTest {
	public static void main(String[] args) {

		int[]  sus={30,2,65,5,98,45,76,18,34,12,53,33};
		int pos1=Arrays.binarySearch(sus,30);
		System.out.println("Before : "+ Arrays.toString(sus));
		System.out.println("Before : "+ pos1);
		
		Arrays.sort(sus);
		
		int pos2=Arrays.binarySearch(sus,30);		
		System.out.println("After : "+ Arrays.toString(sus));
		System.out.println("After : "+ pos2);
	}
}
