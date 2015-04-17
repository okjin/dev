package day1.s1.array;

public class ArrayEx1 {
	public static void main(String[] args) {
		int[] jumsu = { 90, 89, 76, 80, 45, 89, 89, 94, 55, 90 };

		int count = 0;
		for (int jum : jumsu) {
			if (jum >= 80) {
				count++;
			}
		}
		System.out.println("80점 이상인 학생수 : " + count);
		
		
		int sum = 0;
		for (int jum : jumsu) {
			sum += jum;
		}
		System.out.println("평균 점수 : " + sum / jumsu.length);
		
		
		int avg = sum / jumsu.length;
		for (int jum : jumsu) {
			System.out.print(jum - avg + "  ");
		}
		System.out.println();
		
		
		int max = jumsu[0];
		int index = 0;
		for (int i = 1; i < jumsu.length; i++) {
			if (max < jumsu[i]) {
				max = jumsu[i];
				index = i;
			}
		}
		System.out.println("max value: " + max + ", index : " + index);
		
		
		int min = jumsu[0];
		for (int i = 1; i < jumsu.length; i++) {
			if (min > jumsu[i]) {
				min = jumsu[i];
			}
		}
		System.out.println("min value: " + min);
		
		
		System.out.println("높은 점수 - 낮은 점수 : " + (max - min));
	}
}
