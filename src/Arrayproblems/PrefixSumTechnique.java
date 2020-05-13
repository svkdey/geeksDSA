package Arrayproblems;

public class PrefixSumTechnique {
	public static int prefixSumTechnique(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		int[] prefix_arr = genPrefixArr(arr);

		// precomputation o(n) .retieve arr[r]-arr[l-1]
		if (l > 0) {
			return prefix_arr[r] - prefix_arr[l - 1];
		} else {
			return prefix_arr[r];
		}

	}

	public static int[] genPrefixArr(int[] arr) {
		int[] prefix_arr = new int[arr.length];
		prefix_arr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefix_arr[i] = prefix_arr[i - 1] + arr[i];
		}
		return prefix_arr;
	}

	public static int getSum(int[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static int equilibriumPoint(int[] arr) {
		int sum = getSum(arr, 0, arr.length);

		int leftSum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			sum -= arr[i];
			if (sum == leftSum)
				return arr[i];
			leftSum += arr[i];
		}
		return -1;

	}
//important
	public static int NrangeMaxFrequencyNumber(int[] l, int[] r, int n) {
		int[] arr = new int[1000];
		for (int i = 0; i < n; i++) {
			arr[l[i]]++;
			arr[r[i] + 1]--;
		}
		int max = arr[0];
		int res = 0;
		for (int i = 1; i < 1000; i++) {
			arr[i] += arr[i - 1];
			if (arr[i] > max) {
				max = arr[i];
				res = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 2, -2 };
//		System.out.println(prefixSumTechnique(arr, 0, 3));
//		System.out.println(equilibriumPoint(arr));
		System.out.println(NrangeMaxFrequencyNumber(new int[] { 1, 2, 3 }, new int[] { 3, 5, 7 }, 3));
	}

}
