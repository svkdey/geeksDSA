package Searching;

public class SortedArraySearch {
	public static int sortedArrayProblem(int[] arr, int x, int high, int low) {
		if (low > high) {
			return -1;
		} else {
//			int mid=(high+low)/2;
//better expression 
			int mid = low + (high - low) / 2;

			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x) {
				return sortedArrayProblem(arr, x, mid - 1, low);
			} else {
				return sortedArrayProblem(arr, x, high, mid + 1);
			}
		}
	}

	public static int lestMostOccurance(int[] arr, int x, int high, int low) {
		if (low > high) {
			return -1;
		} else {
//			int mid=(high+low)/2;
//better expression 
			int mid = low + (high - low) / 2;
//find the element.
			// get most left element arr[mid-1]!=x
			if (arr[mid] == x && (mid == 0 || arr[mid - 1] != x))
				return mid;
			if (arr[mid] >= x) {
				return lestMostOccurance(arr, x, mid - 1, low);
			} else {
				return lestMostOccurance(arr, x, high, mid + 1);
			}
		}
	}

	public static int rightMostOccurance(int[] arr, int x, int high, int low, int n) {
		if (low > high) {
			return -1;
		} else {
//			int mid=(high+low)/2;
//better expression 
			int mid = low + (high - low) / 2;
//find the element.
			// get most left element arr[mid-1]!=x
			if (arr[mid] == x && (mid == n - 1 || arr[mid + 1] != x))
				return mid;
			if (arr[mid] > x) {
				return rightMostOccurance(arr, x, mid - 1, low, n);
			} else {
				return rightMostOccurance(arr, x, high, mid + 1, n);
			}
		}
	}

//o(log n)
	public static int findOccuranceOfX(int[] arr, int x, int high, int low) {
		int leftIdx = lestMostOccurance(arr, x, high, low);
		int rightIdx = rightMostOccurance(arr, x, high, low, arr.length);
		return rightIdx - leftIdx + 1;
	}

	public static int findIndexInAnInfiniteArray(int[] arr, int x, int low) {
		if (arr[0] == x)
			return 0;
		int i = 1;
		while (arr[i] < x) {
			i = i * 2;
		}
		if (arr[i] == x)
			return i;
		return sortedArrayProblem(arr, x, i, i / 2);

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findOccuranceOfX(new int[] { 0, 0, 1, 1, 1, 1 }, 1, 5, 0));
	}

}
