package LeetCode;

import java.util.Stack;

public class LeetCode735 {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int particle : asteroids) {
			if (stack.isEmpty()) {
				stack.push(particle);
			} else {
				if (particle < 0) {
					while (!stack.isEmpty() && particle != 0 && stack.peek() > 0) {
						if (stack.peek() + particle < 0) {
							stack.pop();
						} else if (stack.peek() + particle > 0) {
							particle = 0;
						} else if (stack.peek() + particle == 0) {
							stack.pop();
							particle = 0;
						}
					}
					if (particle != 0) {
						stack.push(particle);
					}

				} else {
					stack.push(particle);
				}
			}
		}
		System.out.println(stack);
		int n = stack.size();
		int ans[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			ans[i] = stack.pop();
		}
		return ans;
	}
}
