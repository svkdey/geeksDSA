package LeetCode.InterviewPrep;

import java.util.Arrays;
import java.util.Stack;

public class LargestAreaInHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		int L[] = NSL(heights);
		int R[] = NSR(heights);
		System.out.println(Arrays.toString(L) + "  " + Arrays.toString(R));
		int W[] = new int[heights.length];
		int ans = 0;
		for (int i = 0; i < heights.length; i++) {
			W[i] = R[i] - L[i] - 1;
			int area = heights[i] * W[i];
			ans = Math.max(area,ans);
		}

		return ans;

	}

	public int[] NSL(int[] heights) {
		int res[] = new int[heights.length];
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < heights.length; i++) {
			if (s.isEmpty()) {
				s.add(i);
				res[i] = -1;
			} else {
				while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
					s.pop();
				}
				res[i] = s.isEmpty() ? -1 : s.peek();
				s.add(i);
			}
		}
		return res;

	}

	public int[] NSR(int[] heights) {
		int res[] = new int[heights.length];
		Stack<Integer> s = new Stack<Integer>();
		for (int i = heights.length - 1; i >= 0; i--) {
			if (s.isEmpty()) {
				s.add(i);
				res[i] = heights.length;
			} else {
				while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
					s.pop();
				}
				res[i] = s.isEmpty() ? heights.length : s.peek();
				s.add(i);
			}
		}
		return res;
	}
	
}
