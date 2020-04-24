package Arrayproblems;

public class EquilibriumPoint {
	static long equilibriumPoint(long[] arr) {

		// Your code here
		if(arr.length==1) return arr[0];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		long leftSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			leftSum += arr[i];

			if (sum == leftSum) {
				return i+1;
			}
			sum -= arr[i];
		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(equilibriumPoint(new long[] { 1, 3, 5, 2, 2 }));
	}

}
