package Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LongestConsicutiveElement {
	// o(nlogN +N) solution
	static void longestConsicutiveElementSol1(int arr[]) {
		Arrays.sort(arr);
		int res = 1;
		int maxVal = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == 1) {
				res++;
			} else {
				maxVal = Math.max(res, maxVal);
				res = 1;
			}
		}
		maxVal = Math.max(res, maxVal);
		System.out.println(maxVal);
	}

	static void longestConsicutiveElementSol2(int arr[]) {
		//worst case n^2 but good case n
		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
		for (int i : arr) {
			hs.add(i);
		}
		int result = 0;
		System.out.println(hs);
		for (int i : arr) {
			if (hs.contains(i - 1)) {
				int count = 1;
				int current = 0;
				while (hs.contains(i + current)) {
					count++;
					current++;
				}
				result = Math.max(count, result);
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestConsicutiveElementSol2(new int[] {10,11,15,20 });
	}

}
