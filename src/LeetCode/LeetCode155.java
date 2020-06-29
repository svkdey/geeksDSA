package LeetCode;

import java.util.PriorityQueue;
import java.util.Stack;

public class LeetCode155 {
	static class MinStack {

		/** initialize your data structure here. */

		Stack<Integer> s1 = null;
		Stack<Integer> s2 = null;

		public MinStack() {

			this.s1 = new Stack<Integer>();
			this.s2 = new Stack<Integer>();

		}

		public void push(int x) {

			s1.add(x);

		}

		public void pop() {
//			int item = Integer.MAX_VALUE;
//			while (!s1.isEmpty()) {
//				int x = s1.pop();
//				item = Math.min(x, item);
//				s2.push(x);
//			}
//			while (!s2.isEmpty()) {
//				int x = s2.pop();
//				if (x != item) {
//					s1.push(x);
//				}
//			}
			s1.pop();
		}

		public int top() {
			return s1.peek();

		}

		public int getMin() {
			int item = Integer.MAX_VALUE;
			while (!s1.isEmpty()) {
				int x = s1.pop();
				item = Math.min(x, item);
				s2.push(x);
			}
			while (!s2.isEmpty()) {
				int x = s2.pop();

				s1.push(x);

			}
			return item;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		System.out.println(minStack.getMin()); // return -3
		System.out.println(minStack.top());
		minStack.pop();
		    // return 0
		System.out.println(minStack.getMin());
	}

}
