package day1.s2.bit;

public class BitTest1 {
	public static void main(String[] args) {
		int a=15;
		int b=45;
		
		System.out.printf("%32s\n",Integer.toBinaryString(a));
		System.out.printf("%32s\n",Integer.toBinaryString(b));
		System.out.println();
		System.out.printf("%32s\n",Integer.toBinaryString(a&b));
		System.out.printf("%32s\n",Integer.toBinaryString(a|b));
		System.out.printf("%32s\n",Integer.toBinaryString(a^b));
	}
}


