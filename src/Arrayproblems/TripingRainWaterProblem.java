package Arrayproblems;

public class TripingRainWaterProblem {
	/*
	 * solution:1 O(n^2) 
	 * for a each bar we need to find -rightHandSide max bar
	 * length; -left hand side max bar length -now water stored by each bar
	 * Math.min(rMax,lMax)-arr[i] totalStored water= i=0 to i=end
	 * 
	 */
	public static int tripingRainWaterProblem(int[] arr, int start, int end) {

		int totalVol = 0;
		for (int i = start; i < end - 1; i++) {
			int lMax = arr[i];
			for (int j = 0; j < i; j++) {
				lMax = Math.max(lMax, arr[j]);
			}
			int rMax = arr[i];
			for (int j = i + 1; j < end; j++) {
				rMax = Math.max(rMax, arr[j]);
			}
			totalVol += Math.min(rMax, lMax) - arr[i];
		}

		return totalVol;
	}

	/*
	 * solution:1 O(n) for a each bar we need to find -rightHandSide max bar
	 * length; -left hand side max bar length by precomputation. -now water stored by
	 * each bar Math.min(rMax,lMax)-arr[i] totalStored water= i=0 to i=end
	 * 
	 */
	public static int tripingRainWaterProblem2(int[] arr, int start, int end) {

		int totalVol = 0;
		int[] lMax = new int[end];
		int[] rMax = new int[end];
		// start from left to compute lmax
		lMax[0] = arr[0];
		for (int j = 1; j < end; j++) {
			lMax[j] = Math.max(lMax[j - 1], arr[j]);
		}
		// start from right to compute rmax
		rMax[end - 1] = arr[end - 1];
		;
		for (int j = end - 2; j >= 0; j--) {
			rMax[j] = Math.max(rMax[j + 1], arr[j]);
		}
		for (int i = start; i < end - 1; i++) {
			totalVol += Math.min(rMax[i], lMax[i]) - arr[i];
		}
		;
		return totalVol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 0, 3, 1, 2, 5, 0, 2 };
		System.out.println(tripingRainWaterProblem(arr, 0, 8));
		System.out.println(tripingRainWaterProblem2(arr, 0, 8));
	}

}
