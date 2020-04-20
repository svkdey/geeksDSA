package Arrayproblems;

public class MaxSumSubArray {
	//also known as kadane's algorithm
	// o(n)

	//	maxEnding[i]=max(maxEnding[i-1]+arr[i],arr[i])
	//	result=max(result,maxEnding)
	
	public static int maxSumSubArray(int[] arr, int n) {
		int maxEnding = arr[0];
		int result = arr[0];
		for (int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			result = Math.max(result, maxEnding);
		}

		return result;
	}
	public static int maxSumCircularSubArray(int[] arr, int n) {
		int maxEnding = arr[0];
		int result = arr[0];
		for (int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			result = Math.max(result, maxEnding);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -5, 1, -2, 3, -1, 2, -2 };
		System.out.println(maxSumSubArray(arr, 7));
	}

}
