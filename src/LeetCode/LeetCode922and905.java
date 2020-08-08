package LeetCode;

import java.util.ArrayList;

public class LeetCode922and905 {
	public int[] sortArrayByParityII(int[] A) {

		int n = A.length;

		int ans[] = new int[n];
		int odd = 1;
		int even = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] % 2 == 0) {
				ans[even] = A[i];
				even += 2;
			} else {
				ans[odd] = A[i];
				odd += 2;
			}
		}
		return ans;
	}

	public int[] sortArrayByParity(int[] A) {
		int n = A.length;

		int ans[] = new int[n];
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (A[i] % 2 == 0) {
				even.add(A[i]);
			} else {
				odd.add(A[i]);
			}
		}
		int start = 0;
		for (int x : even) {
			ans[start++] = x;
		}
		for (int x : odd) {
			ans[start++] = x;
		}

		return ans;
	}
}
