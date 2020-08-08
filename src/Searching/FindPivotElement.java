package Searching;

public class FindPivotElement {
	public static int solve(int arr[], int key) {
		int s = 0, e = arr.length - 1;
		// 1st find break point,
//		then find if it is really a break point if left and right us monotonic function

		while (e >= s) {
			int mid = s + (e - s) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[s] <= arr[mid]) {
				if (key >= arr[s] && key <= arr[mid]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}

			} else {
				if (key >= arr[mid] && key <= arr[e]) {

					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
			
		}
		return -1;

	}
}
