package Playground;

import java.util.Stack;

public class StepCount {
	// arr[]: input array
	// n: size of the array
	static int maxStep(int arr[], int n) {

		// Your code here
		Stack<Integer> stack = new Stack<Integer>();
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(count+"--->"+stack);
			if (stack.isEmpty()) {
				stack.push(arr[i]);
			} else {
				if (!stack.isEmpty() && (stack.peek()) <arr[i]) {
					count++;
					stack.push(arr[i]);
				} else {
					while (!stack.isEmpty()) {
						stack.pop();
					}
					maxCount = Math.max(count, maxCount);
					count = 0;
					stack.push(arr[i]);
				}
			}
		}
		maxCount = Math.max(count, maxCount);
		return maxCount;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1 ,2 ,2 ,3 ,2};
		int arr2[]= {1 ,2  ,3 ,4};
		int arr3[]= {6 ,9 ,2 ,7 ,5 ,4 ,1 ,9};
		System.out.println(maxStep(arr3, arr3.length));
		
	}

}
