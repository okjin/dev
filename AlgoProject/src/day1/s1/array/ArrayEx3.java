package day1.s1.array;

public class ArrayEx3 {

	String[] customers = { "김도훈", "박건영", "박용우", "최아람", "정세은", "이시연" };
	int index = customers.length;

	public void delete(String name) {
		for (int i = 0; i < index; i++) {
			if (name.equals(customers[i])) {
				System.arraycopy(customers, i+1, customers, i, index-1-i);
				customers[--index]=null;
				break;
			}
		}
	}

	public void print() {
		for (int i = 0; i < index; i++) {
			System.out.print(customers[i] + " ");
		}
		System.out.println();
	}

	public int indexOf(String name) {
		for (int i = 0; i < index; i++) {
			if (name.equals(customers[i])) {
				return i;
			}
		}
		return -1;
	}

	public void add(String name) {
		if (index == customers.length) {
			String[] temp = new String[customers.length * 2];
			System.arraycopy(customers, 0, temp, 0, customers.length);
			customers = temp;
		}
		customers[index++] = name;
	}
	public static void main(String[] args) {
		ArrayEx3 test = new ArrayEx3();
		test.print();
		test.delete("최아람");
		test.print();
		System.out.println("정세은 위치:" + test.indexOf("정세은"));
		test.add("박건우");
		test.add("김선미");
		test.print();
	}
}
