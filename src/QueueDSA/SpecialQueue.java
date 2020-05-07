package QueueDSA;

import java.util.Deque;
import java.util.LinkedList;

public class SpecialQueue {
	Deque<Integer> dq = new LinkedList<>();

	public SpecialQueue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SpecialQueue [dq=" + dq + "]";
	}

	void insertMin(int data) {
		dq.offerFirst(data);
	}

	void insertMax(int data) {
		dq.offerLast(data);
	}

	int getMin() {
		return dq.peekFirst();
	}

	int getMax() {
		return dq.peekLast();
	}

	int removeMin() {
		return dq.removeFirst();
	}

	int removeMax() {
		return dq.removeLast();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialQueue q = new SpecialQueue();
		q.insertMin(10);
		q.insertMax(200);
		q.insertMin(25);
		q.insertMax(210);
		q.insertMin(11);
		q.insertMax(2020);
		System.out.println(q.getMax());
		System.out.println(q.getMin());
		System.out.println(q.removeMax());
	}

}
