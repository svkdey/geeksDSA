package Searching;

public class PeakFinder {
	public int peakElement(int[] arr, int n) {
		// add code here.
		int start = 0;
		int end = n - 1;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
