package LeetCode;

import java.util.Stack;

public class LeetCode1381 {
	class CustomStack {
		Stack<Integer> s = null;
		int maxS = -1;
		int i = 0;

		public CustomStack(int maxSize) {
			s = new Stack<>();
			maxS = maxSize;
		}

		public void push(int x) {
			if (i != maxS - 1) {
				i++;
				s.add(x);
			}
		}

		public int pop() {
			if (!s.isEmpty()) {
				i--;
				return s.pop();
			} else {
				return -1;
			}
		}

		public void increment(int k, int val) {
			
			Stack<Integer> aux=new Stack<Integer>();
			if(k>=s.size()) {
				while(!s.isEmpty()) {
					aux.push(val+s.pop());
				}
			}
			else {
				int i=s.size()-k;
				while(!s.isEmpty()&&i!=0) {
					i--;
					aux.push(s.pop());
				}
				while(!s.isEmpty()) {
					aux.push(val+s.pop());
				}
			}
			while(!aux.isEmpty()) {
				s.push(aux.pop());
			}
		}
	}

}
