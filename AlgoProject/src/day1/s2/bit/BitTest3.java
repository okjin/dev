package day1.s2.bit;

public class BitTest3 {
	public static void main(String[] args) {
		int a=15;
		int b=45;	
		
		a=a<<16;
		a=a+b;
		System.out.printf("%32s\n",Integer.toBinaryString(a));
		int mask=(1<<16)-1 ;  
		System.out.printf("%32s\n",Integer.toBinaryString(mask));
		
		System.out.printf("%32s\n",Integer.toBinaryString(a&mask));
		a=a>>16;
		System.out.printf("%32s\n",Integer.toBinaryString(a&mask));
	}
}


