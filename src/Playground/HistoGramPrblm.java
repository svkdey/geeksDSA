package Playground;

import java.util.Stack;

public class HistoGramPrblm {
	public static int maxAreaOfHistogram(int arr[]) {
		Stack<Integer> s = new Stack<>();
		int area = 0;
		int i = 0;

		int area_with_currentTop = 0;
		while (i < arr.length) {
			// If this bar is higher than the bar on top stack, push it to stack
			if (s.isEmpty() || arr[s.peek()] < arr[i]) {
				i++;
				s.push(i);
			} else {
				// If this bar is lower than top of stack, then calculate area of rectangle
				// with stack top as the smallest (or minimum height) bar. 'i' is
				// 'right index' for the top and element before top in stack is 'left index
				int top = s.pop();

				area_with_currentTop = arr[top] * (s.empty() ? i : i - 1 - s.peek());
				area = Math.max(area, area_with_currentTop);
			}
		}
		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (s.empty() == false) {
			int top = s.peek();
			s.pop();
			area_with_currentTop = arr[top] * (s.empty() ? i : i - s.peek() - 1);

			area = Math.max(area, area_with_currentTop);
		}

		return area;

	}

	public static void main(String[] args) {
		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };

		System.out.println(maxAreaOfHistogram(arr));
	}
}
