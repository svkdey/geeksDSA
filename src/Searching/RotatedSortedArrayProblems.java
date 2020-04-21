package Searching;

public class RotatedSortedArrayProblems {
	static int pivotedBinarySearch(int arr[], int n, int key) {
		int pivot = findPivot(arr, 0, n - 1);

		// If we didn't find a pivot, then
		// array is not rotated at all
		if (pivot == -1)
			return binarySearch(arr, 0, n - 1, key);

		// If we found a pivot, then first
		// compare with pivot and then
		// search in two subarrays around pivot
		
		
		if (arr[pivot] == key)
			return pivot;
		
		//key>=arr[0] then element is in 0 to pivot-1;else pivot+1 to n-1
		if (arr[0] <= key)
			return binarySearch(arr, 0, pivot - 1, key);
		return binarySearch(arr, pivot + 1, n - 1, key);
	}

	/*
	 * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns 3 (index of 6)
	 */
	
	//finding pivot==finding largest element in arr
	static int findPivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		
		int mid = low + (high - low)/2;
		// if arr[mid] is greater right hand element then its a pivot
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		
		// if arr[mid] is less that left hand element then its a pivot
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

	/* Standard Binary Search function */
	static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;

		/* low + (high - low)/2; */
		int mid = low + (high - low)/2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(pivotedBinarySearch(new int[] {4,7,9,11,1,2 ,3}, 7, 3));
	}

}
