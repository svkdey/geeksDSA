package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode739 {
	//consider problem as last greater element
	public static int[] dailyTemperatures(int[] T) {
		int result[] = new int[T.length];

		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < T.length; i++) {

			if (!s.isEmpty() && T[s.peek()] < T[i]) {
				while (!s.isEmpty() && T[s.peek()] < T[i]) {
					int idx = s.pop();
					result[idx] = i - idx;

				}

				s.add(i);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
		System.out.println(Arrays.toString(dailyTemperatures(temp)));
	}

}
