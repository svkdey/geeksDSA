package StackDSA;

import java.util.Stack;

import Data.StackData;

public class StockSpanPrblem {

	// o(n*2)
	static void stockSpanPrblmNaive(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int span = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] >= arr[j]) {
					span++;
				} else {
					break;
				}
			}
			System.out.println(span);
		}
	}

	/*
	 * idea is to find immediate greater element on left hand side of the element .
	 * if no such element found take the number of element on lefthand side +1 
	 * 16 4 30 1 1 3 1 5
	 */
	static void stockSpanPrblmEffecientSolution(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		//push 1st element's index
		s.push(0);
		for (int i = 0; i < arr.length; i++) {
			//check if empty or not as we need to access the top
			//if arr[top]<arr[i] ,pop out until arr[i]>arr[top]
			//else span i-stackTopValue ie index of last push value;
			//print
			//stack.push new index 
			while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
				s.pop();
			}
			int span = s.isEmpty() ? (i + 1) :( i - s.peek());
			System.out.println(span);
			s.push(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stockSpanPrblmEffecientSolution(StackData.arrangeData);
	}

}
