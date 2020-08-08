package Searching;

public class PeakFinder {
	public static int peakElement(int[] arr, int n) {
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
		int arr[] = {2, 3, 4, 5, 6, 7, 9};
		System.out.println(peakElement(arr,arr.length));
	}

}
