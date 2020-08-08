package LeetCode;

import java.util.*;
import java.util.HashSet;

public class LeetCode1122 {
	private static void swap(int arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], i);
		}
	TreeMap<Integer, Integer> map2 = new TreeMap<>();

		for (int i = 0; i < arr1.length; i++) {
			map2.put(arr1[i], map2.getOrDefault(arr1[i], 0) + 1);
		}

		HashSet<Integer> inSolution = new HashSet<Integer>();
		int ans[] = new int[arr1.length];
		int k = 0;
		for (int x : map.keySet()) {
			int j = map2.get(x);
			while (j != 0) {
				ans[k++] = x;
				j--;
			}
			inSolution.add(x);
		}
		for (int x : map2.keySet()) {
			if (!inSolution.contains(x)) {
				int j = map2.get(x);
				while (j != 0) {
					ans[k++] = x;
					j--;
				}
				inSolution.add(x);
			}
		}
//		System.out.println(Arrays.toString(ans));
		return ans;

	}

	public static void main(String[] args) {
		int arr1[] = {2,3,1,3,2,4,6,7,9,2,19}, arr2[]= {2,1,4,3,9,6};
		relativeSortArray(arr1,arr2);
	}
}
