package Playground;

import java.util.HashMap;

public class SubArrayWithZeroorKAndLengthOFArray {
	public static boolean solveZeroSum(int arr[], int n) {
		int preFixSum = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			preFixSum += arr[i];
			if (preFixSum == 0 || hm.containsKey(preFixSum)) {
				return true;
			} else {
				hm.put(preFixSum, i);
			}
		}
		return false;
	}

	public static int solveZeroSumLen(int arr[], int n) {
		int preFixSum = 0;
		int len = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			preFixSum += arr[i];
			if (preFixSum != 0 && hm.containsKey(preFixSum)) {
				len = Math.max(len, i - hm.get(preFixSum));
			}
			if (preFixSum == 0) {
				len = Math.max(len, i + 1);
			}

			else {
				hm.put(preFixSum, i);
			}
		}
		return len;
	}

	public static boolean solveKSum(int arr[], int n, int k) {
		int preFixSum = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			preFixSum += arr[i];
			int diff = preFixSum - k;
			if(arr[i]-k==0) {
				return true;
			}
			if (diff == 0 || hm.containsKey(diff)) {
				return true;
			} else {
				hm.put(preFixSum, i);
			}
		}
		System.out.println(hm);
		return false;
	}
	public static int solveKLen(int arr[], int n, int k) {
		int preFixSum = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int len=0;
		for (int i = 0; i < n; i++) {
			preFixSum += arr[i];
			int diff = preFixSum - k;
			if(diff==0) {
				len=Math.max(len,i+1);
			}
			if (hm.containsKey(diff)) {
				len=Math.max(len,i-hm.get(diff));
			} else {
				hm.put(preFixSum, i);
			}
		}
		System.out.println(hm);
		return len;
	}


	public static void main(String[] args) {
		int arr[] = {1,4,-5,4,5,-5 };

		System.out.println(solveZeroSumLen(arr, arr.length));
		System.out.println(solveKLen(arr, arr.length,4));
	}

}
