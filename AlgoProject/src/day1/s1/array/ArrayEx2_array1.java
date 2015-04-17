package day1.s1.array;

import java.util.Arrays;

public class ArrayEx2_array1 {
	public static void main(String[] args) {
		
		
		long start=System.nanoTime();
		
		int[] jumsu = { 90, 89, 76, 80, 45, 89, 89, 94, 55, 90 };
		int[] result = new int[101];
		
		for(int i = 0; i < jumsu.length; i++)
		{
			result[jumsu[i]]++;
		}
		
		int count = 0;
		int bestscore = 0; 
		for(int i = 0; i < result.length; i++)
		{
			if(result[i] != 0)
			{
				if(result[i] > count)
				{
					count = result[i];
					bestscore = i;
				}
				
				System.out.printf("%d점 - %d명 \n", i, result[i]);
			}
		}
		
		System.out.printf("가장많은 점수 %d점\n", bestscore);
		long end=System.nanoTime();
		System.out.println(end-start);//20989938
	}                                 //  459274                       
}                                     //  849638
