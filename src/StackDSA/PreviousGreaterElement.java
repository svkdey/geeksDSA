package StackDSA;

import java.util.Arrays;
import java.util.Stack;

import Data.StackData;

public class PreviousGreaterElement {
	static void prevgreaterElement(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					System.out.print(arr[j] + " ");
					break;
				}

			}
			if (j == -1) {
				System.out.print(-1 + " ");
			}

		}
		System.out.println();
	}

	static int [] prevgreaterElementEffective(int arr[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(arr[0]);
		int prev[]=new int[arr.length];
		prev[0]=-1;
		for (int i = 1; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] >= s.peek()) {
				s.pop();
			}
			int lastGreaterElement = s.isEmpty() ? -1 : s.peek();
			prev[i]=lastGreaterElement;
			
			s.push(arr[i]);
		}
		System.out.println(Arrays.toString(prev));
		return prev;
	}

	static int [] nextgreaterElementEffective(int arr[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(arr[arr.length-1]);
		int result[]=new int[arr.length];
		result[arr.length-1]=-1;
		for (int i = arr.length-2; i>=0; i--) {
			while (!s.isEmpty() && arr[i] >= s.peek()) {
				s.pop();
			}
			int lastGreaterElement = s.isEmpty() ? -1 : s.peek();
			result[i]=lastGreaterElement;
			s.push(arr[i]);
		}
		System.out.println(Arrays.toString(result));
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
//		prevgreaterElement(StackData.arrangeData);
//		prevgreaterElementEffective(StackData.arrangeData);
		int arr[]= {1,2,1};
		nextgreaterElementEffective(arr);
	}

}
