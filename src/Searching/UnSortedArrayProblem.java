package Searching;

public class UnSortedArrayProblem {
	public static int unSortedArrayProblem(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * 1.if both side of a element is bigger but element is not the peak then ,there
	 * is chance that element in left and right side both 2.if one is bigger.peak is
	 * in the bigger side. 3.if both side is smaller then its a peak.
	 * 
	 */
	// A binary search based function that returns index of a peak
	// element
	public static int findPeakUtil(int arr[], int low, int high, int n) {
		// Find index of middle element


		int mid = low + (high - low) / 2;

		// Compare middle element with its neighbours (if neighbours
		// exist) ie peak finding condition
		// extreme corner peak is taken
//		if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
//			return mid;

		// corner peak is not taken
		if(mid>0) {
		if ((arr[mid - 1] <= arr[mid]) && (arr[mid + 1] <= arr[mid]))
			return mid;
		// If middle element is not peak and its left neighbor is
		// greater than it,then left half must have a peak element ...so move Binary
		// Search to left
		else if (mid > 0 && arr[mid - 1] > arr[mid])
			return findPeakUtil(arr, low, (mid - 1), n);

		// If middle element is not peak and its right neighbor
		// is greater than it, then right half must have a peak
		// element so move Binary Search to right
		else
			return findPeakUtil(arr, (mid + 1), high, n);
		}
		else return -1;
	}

	// A wrapper over recursive function findPeakUtil()

	public static int peakElement(int[] arr, int x, int low, int high) {

		return findPeakUtil(arr, low, high, x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(peakElement(new int[] {1,20,300,3,165},5, 0, 2));
	}

}
