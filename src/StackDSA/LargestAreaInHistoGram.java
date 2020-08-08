package StackDSA;

import java.util.Stack;

public class LargestAreaInHistoGram {
	// idea is the for a given bar find area on right hand side and left hand side
	// at i current area= arr[i];
	// if left hand side >arr[i] then current+=arr[i] . same goes for right hand
	// side .
	// o(n*2n)
	static int largestAreaInHistogram(int arr[]) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					current += arr[i];
				} else {
					break;
				}
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					current += arr[i];
				} else {
					break;
				}
			}
			res = Math.max(res, current);
		}
		return res;
	}

	// better solution

//	find all the area of bars which has next-smaller element and compute value to that and get the max of all such value
//after that step stack contains only the element who has no smaller element next to it
	// find the area by those value and max of it
	// finally take max of booth type values

	static int largestAreaInHistogramLinearSolution(int arr[]) {
		Stack<Integer> s = new Stack<Integer>();

		int area = 0, maxArea = -1;
		int top = 0;

		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
				// area =arr[top] * ((i-1)-left+1))
				top = s.pop();
				int left = s.isEmpty() ? -1 : s.peek();
				area = arr[top] * ((i - 1) - left);
				maxArea = Math.max(area, maxArea);
			}

			s.add(i);

		}

		while (!s.isEmpty()) {
			top = s.pop();
			int left = s.isEmpty() ? -1 : s.peek();
			area = arr[top] * ((arr.length - 1) - left);
			maxArea = Math.max(area, maxArea);
		}

		System.out.println(maxArea);
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestAreaInHistogramLinearSolution(new int[] { 1, 2, 1 }));
	}

}
