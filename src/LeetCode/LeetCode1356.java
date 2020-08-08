package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode1356 {
	private int numberOfsetBit(int num) {
		int ans = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				ans++;
			}
			num = num >>> 1;
		}
		return ans;
	}

	public int[] sortByBits(int[] arr) {
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 32; i++) {
			l.add(new ArrayList<Integer>());
		}
		for (int x : arr) {
			l.get(numberOfsetBit(x)).add(x);
		}

		// System.out.println(l);
		int result[] = new int[arr.length];
		int rIdx = 0;
		for (int i = 0; i < 32; i++) {
			if (l.get(i).size() > 0) {
				Collections.sort(l.get(i));
				for (int element : l.get(i)) {
					result[rIdx++] = element;
				}

			}
			// System.out.println(Arrays.toString(result));
			
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode1356 s = new LeetCode1356();
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		s.sortByBits(arr);

	}
}
