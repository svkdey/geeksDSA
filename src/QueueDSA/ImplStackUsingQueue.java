package QueueDSA;

import java.util.LinkedList;
import java.util.Queue;

public class ImplStackUsingQueue {
	public Queue<Integer> mq = null;
	public Queue<Integer> aq = null;

	public ImplStackUsingQueue() {
		this.mq = new LinkedList<Integer>();
		this.aq = new LinkedList<Integer>();
	}

	private void push(int x) {
		// TODO Auto-generated method stub
		if (this.mq.isEmpty()) {
			this.mq.add(x);
		} else {
			while (!this.mq.isEmpty()) {
				this.aq.add(this.mq.remove());
			}
			this.mq.add(x);
			while (!this.aq.isEmpty()) {
				this.mq.add(this.aq.remove());
			}
		}
	}

	boolean isEmpty() {
		return mq.isEmpty();
	}

	int pop() {
		if (!mq.isEmpty()) {
			return mq.remove();
		} else {
			System.exit(1);
			return 0;
		}
	}

	@Override
	public String toString() {
		return "ImplStackUsingQueue [mq=" + mq + ", aq=" + aq + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplStackUsingQueue q = new ImplStackUsingQueue();
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(40);
		System.out.println(q);
		System.out.println(q.isEmpty());
		while (!q.isEmpty()) {
			System.out.println(q.pop());
		}

	}

}
