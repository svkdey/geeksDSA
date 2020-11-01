package StackDSA;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNumber {
	public static void printNGE(long[] arr, int n) {
		// Your code here

		for (int i = 0; i < n; i++) {
			boolean found = false;
			for (int j = i + 1; j < n; j++) {
				if (!found && arr[j] > arr[i]) {
					found = true;
					System.out.print(arr[j] + " ");
					break;
				}
			}
			if (!found) {
				System.out.print(-1 + " ");
			}
		}
	}

	public static void printNGESoltutionTwo(long[] arr, int n) {
		// Your code here
		Stack<Long> s = new Stack<>();
		Stack<Long> t = new Stack<>();
		t.push((long) -1);
		s.push(arr[n - 1]);
//	        6 ,8, 0, 1, 3
		for (int i = n - 2; i > -1; i--) {
			if (arr[i] < s.peek()) {
				t.push(s.peek());
				s.push(arr[i]);
			}

			else {
				while (!s.empty() && s.peek() < arr[i]) {
					s.pop();
				}
				if (s.empty()) {
					t.push((long) -1);
				} else {
					t.push(s.peek());
				}
				
				s.push(arr[i]);
			}
		}
		System.out.println(t + " " + s);
		while (!t.empty())
			System.out.print(t.pop() + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = {1,2,1,3};
		System.out.println(Arrays.toString(arr));
		printNGESoltutionTwo(arr, arr.length);
	}

}
