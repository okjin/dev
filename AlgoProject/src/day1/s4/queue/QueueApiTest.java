package day1.s4.queue;

import java.util.PriorityQueue;

public class QueueApiTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> intQueue = new PriorityQueue<Integer>();
		intQueue.offer(34);
		intQueue.offer(27);
		intQueue.offer(3);
		intQueue.offer(50);
		intQueue.offer(40);

		int len = intQueue.size();
		for (int i = 0; i < len; i++) {
			System.out.println(intQueue.poll());
		}
		System.out.println();
		
		PriorityQueue<String> sQueue = new PriorityQueue<String>();
		sQueue.offer("CDE");
		sQueue.offer("ABE");
		sQueue.offer("CCE");
		System.out.println(sQueue.poll());
		System.out.println(sQueue.poll());
		System.out.println(sQueue.poll());
	}
}
