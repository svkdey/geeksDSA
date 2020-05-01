package Arrayproblems;

public class MaxSumSubArray {
	// also known as kadane's algorithm
	// o(n)

	// maxEnding[i]=max(maxEnding[i-1]+arr[i],arr[i])
	// result=max(result,maxEnding)

	public static int maxSumSubArray(int[] arr, int n) {
		int maxEnding = arr[0];
		int result = arr[0];
		for (int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			result = Math.max(result, maxEnding);
		}

		return result;
	}

	// naive solution
	public static int maxSumCircularSubArray(int[] arr, int n) {

		int result = arr[0];
		for (int i = 0; i < n; i++) {
			int currentSum = arr[i];
			int maxSum = arr[i];
			for (int j = 1; j < n; j++) {
				int index = (i + j) % n; // to get circular value
				currentSum += arr[index];
				maxSum = Math.max(currentSum, maxSum);
			}
			result = Math.max(result, maxSum);
		}

		System.out.println(result);
		return result;
	}

//	best approach
	/*
	 * 1 maxNormalSum= 1st find normal max Sub array sum 2. sumMinusMinSum= find all
	 * element sum- miniMum sub array sum .return Max(maxNormalSum,sumMinusMinSum)
	 * 
	 */
	public static int maxSumCircularSubArrayTwo(int[] arr, int n) {

		int maxNormalValue = maxSumCircularSubArray(arr, n);
		//approach 1
//		int sumMinusminNormalValue = totalSum(arr, n) - minSumSubArray(arr, n);
		
		//approach 2 invert sign of each arr[i] then find maxSumSubArray(arr, n); then return -1*maxSumSubArray(arr, n)
		int sumMinusminNormalValue = totalSum(arr, n) - minSumSubArrayApproach2(arr, n);
		return Math.max(maxNormalValue, sumMinusminNormalValue);
	}

	public static int totalSum(int[] arr, int n) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		
		System.out.println(sum);return sum;
	}

	public static int minSumSubArray(int[] arr, int n) {
		int maxEnding = arr[0];
		int result = arr[0];
		for (int i = 1; i < n; i++) {
			maxEnding = Math.min(maxEnding + arr[i], arr[i]);
			result = Math.min(result, maxEnding);
		}
		System.out.println(result);
		return result;
	}
	public static int minSumSubArrayApproach2(int[] arr, int n) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=-1*arr[i];
		}
		return -1 *maxSumSubArray(arr, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, -10,-20, 7, 4 };
		System.out.println(maxSumCircularSubArrayTwo(arr, 5));
	}

}
