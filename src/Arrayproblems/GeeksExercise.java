package Arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GeeksExercise {
	public static int majorityWins(int arr[], int n, int x, int y) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int x_count = map.get(x);
		int y_count = map.get(y);
		if (x_count > y_count) {
			return x_count;
		}
		if (x_count == y_count) {
			return Math.max(x, y);
		} else {
			return y_count;
		}

	}

	static void largestAndSecondLargest(int sizeOfArray, int arr[]) {
		ArrayList<Integer> hs = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i : arr) {
			if (!hs.contains(i)) {
				hs.add(i);
			}
		}
		Collections.sort(hs, Collections.reverseOrder());
		System.out.println(hs);
		if (hs.size() > 1) {
			max = hs.get(0);
			max2 = hs.get(1);
		} else {
			max = hs.get(0);
			max2 = -1;
		}
		System.out.println(max + " " + max2);

	}

	public static void reverse(ArrayList<Integer> mv, int start, int end) {
		while (end > start) {
			int temp = mv.get(start);
			mv.set(start, mv.get(end));
			mv.set(end, temp);
			start++;
			end--;
		}
	}

	public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
		// add your code here
		if (k > n) {
			reverse(mv, 0, n - 1);
			return mv;
		} else {
			int start = 0;
			while (n > start) {
				if (n > start + k) {
					reverse(mv, start, start + k - 1);
				}
				start = start + k;
			}
			reverse(mv, start - k, n - 1);

			return mv;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] a = { 5, 6, 8, 9 };
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		System.out.println(reverseInGroups(list, 4, 7));
	}

}
