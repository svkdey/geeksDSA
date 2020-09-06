package LeetCode;

import java.util.Stack;

public class LeetCode1209 {
	static class LastElementDetails {
		int idx;
		int count;

		public LastElementDetails(int idx, int count) {
			super();
			this.idx = idx;
			this.count = count;
		}

		@Override
		public String toString() {
			return "LastElementDetails [idx=" + idx + ", count=" + count + "]";
		}

	}

	public static String removeDuplicates(String s, int k) {
		Stack<LastElementDetails> stack = new Stack<LastElementDetails>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.add(new LastElementDetails(i, 1));
			} else {
				if (s.charAt(i) == s.charAt(stack.peek().idx)) {
					stack.push(new LastElementDetails(i, stack.peek().count + 1));
					if (stack.peek().count == k) {
						int j = k;
						while (!stack.isEmpty() && j != 0) {
							stack.pop();
							j--;
						}
					}
				}else {
					stack.add(new LastElementDetails(i, 1));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(s.charAt(stack.pop().idx));
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		removeDuplicates("deeedbbcccbdaa",3);
	}
}
