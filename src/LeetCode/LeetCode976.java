package LeetCode;

import java.util.Arrays;

public class LeetCode976 {
	public int largestPerimeter(int[] a) {
		if (a.length < 3)
			return 0;
		Arrays.sort(a);
		int perimerter = 0;
		for (int i = a.length - 1; i >= 2; i--) {
			int c = a[i];
			int b = a[i - 1];
			int A = a[i - 2];

			if (A + b > c) {
				return Math.max(perimerter, A + b + c);
			}
		}
		return 0;
	}
}
