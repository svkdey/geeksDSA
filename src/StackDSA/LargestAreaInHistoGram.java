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
		Stack<Integer> s = new Stack<>();
		int res = 0;
		int current = 0;
		for (int i = 0; i < arr.length; i++) {
			// if exist next smaller element

			while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				// get that top value
				int tp = s.pop();
				//
				current = arr[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
				res = Math.max(res, current);

			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			int tp = s.pop();
			//
			current = arr[tp] * (s.isEmpty() ? arr.length : arr.length - s.peek() - 1);
			res = Math.max(res, current);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestAreaInHistogramLinearSolution(new int[] { 1,2,1 }));
	}

}
