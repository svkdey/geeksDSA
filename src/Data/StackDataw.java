package Data;

import java.util.Stack;

public class StackDataw {
	public static Stack<Integer> getStackData() {
		Stack<Integer> s = new Stack<Integer>();
		int[] arr = { 1, 3, 5, 4, 2 };
		for (int i = 0; i < arr.length; i++) {
			s.add(arr[i]);
		}
		return s;
	}
}
