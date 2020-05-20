package Arrayproblems;

public class MaxLenEvenOddSubArray {
//quick select 

	public static int maxLenEvenOddSubArray(int[] arr, int n) {
		// TODO Auto-generated method stub

		int count = 1;
		int prevCount = 1;

		for (int i = 1; i < n; i++) {

			if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
				count++;
				prevCount = Math.max(prevCount, count);
			} else {
				count = 1;
			}
		}
		return prevCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 7, 10, 13, 14 };
		int[] arr1 = { 12, 10, 14, 13, 8 };
		System.out.println(maxLenEvenOddSubArray(arr1, 5));
	}

}
