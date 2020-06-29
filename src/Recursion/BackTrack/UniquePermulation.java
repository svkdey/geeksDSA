package Recursion.BackTrack;

import java.util.Arrays;
import java.util.HashSet;

public class UniquePermulation {
	private static void swap(int arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void solve(int arr[], HashSet<String> s, int i, int n) {
		if (i == n) {

			s.add(Arrays.toString(arr));
			return;
		}

		for (int j = i; j < n; j++) {
			swap(arr, i, j);
			solve(arr, s, i + 1, n);
			swap(arr, i, j);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 2 };
		HashSet<String> s = new HashSet<>();
		solve(arr, s, 0, arr.length);

		System.out.println(s);

	}

}
