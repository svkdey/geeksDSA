package LeetCode;

import java.util.HashMap;

public class LeetCode1386 {
	public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int leftSideseat = masker(new int[] { 2, 3, 4, 5 });
		int rightSideseat = masker(new int[] { 6, 7, 8, 9 });
		int middleSideseat = masker(new int[] { 4, 5, 6, 7 });
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int[] reservedSeat : reservedSeats) {
			int row = reservedSeat[0];
			int col = reservedSeat[1];
			int ans = 0;
			if (map.containsKey(row)) {
				ans = map.get(row);
			}
			ans = ans | (1 << col);
			map.put(row, ans);
		}
		int allocation = 0;
		for (int k : map.keySet()) {
			int colVal = map.get(k);
			int ans = 0;
			if ((colVal & leftSideseat) == 0) {
				ans++;
			}
			if ((colVal & rightSideseat) == 0) {
				ans++;
			}
			if ((colVal & middleSideseat) == 0 && ans == 0) {
				ans = 1;
			}
			allocation += ans;
		}
		return allocation + 2 *(n - map.size());

	}

	public static int masker(int s[]) {
		int res = 0;
		for (int num : s) {
			res = res | (1 << num);
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 2;
		int reservedSeats[][] = { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		System.out.println(maxNumberOfFamilies(n, reservedSeats));
	}
}
