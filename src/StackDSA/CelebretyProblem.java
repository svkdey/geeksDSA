package StackDSA;

import java.util.Stack;

public class CelebretyProblem {
	// asking ,i is probable celebrety?

	static boolean knows(int arr[][], int i, int j) {
		if (arr[i][j] == 1) {
			return false;
		} else {
			return true;
		}
	}

	public static int celebretyProblem(int arr[][], int n) {
		Stack<Integer> s = new Stack<Integer>();
		// pushing all index in stack
		for (int i = 0; i < n; i++) {
			s.push(i);
		}

		// poping 2 and comparing
		// 1.if i knows j ,i may not be celebretry,j may be .. 2.

		// i does not know j . i may be celebrety. j not.

		while (s.size() > 1) {
			int i = s.pop();
			int j = s.pop();
			if (knows(arr, i, j)) {
				s.add(i);
			} else {
				s.add(j);
			}
		}

		int probableCelebrity = s.pop();
		int count = 0;

		// checking for i!=probableCelebrity indexs
		// probableCelebrity should not know i
		// i should know probableCelebrity
		for (int i = 0; i < n; i++) {
			if (i != probableCelebrity && knows(arr, probableCelebrity, i) && !knows(arr, i, probableCelebrity)) {
				count++;
			}
		}

		if (count == n - 1)
			return probableCelebrity;
		else
			return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{0, 1, 0},{ 0 ,0 ,0} ,{0 ,1 ,0} };
		System.out.println(celebretyProblem(arr, 3));
	}

}
