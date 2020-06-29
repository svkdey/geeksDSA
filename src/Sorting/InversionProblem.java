package Sorting;

public class InversionProblem {
	public static int countInversionNaive(int arr[], int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					count++;
				}
			}
		}
		return count;
	}

	/*
	 * inversion of x and y can happen when 1. x and y left 2.x and y in right 3.x
	 * in left and y is in right
	 */
	public static int countInversion(int arr[], int n) {
		return countInversionUtil(arr, 0, n - 1);

	}

	public static int countInversionUtil(int arr[], int start, int end) {
		int res = 0;
		if (end > start) {
			int mid = start + (end - start) / 2;
			res += countInversionUtil(arr, start, mid);
			res += countInversionUtil(arr, mid + 1, end);
			res += countAndmerge(arr, start, mid, end);
		}
		return res;
	}

	public static int countAndmerge(int arr[], int start, int mid, int end) {
		int count = 0;
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int left[] = new int[n1];
		int right[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = arr[i + start];
		}
		for (int i = 0; i < n2; i++) {
			right[i] = arr[i + mid + 1];
		}
		int i = 0, j = 0, k = start;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
				
				count = count + (n1 - i);
			}
			k++;
		}
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}

		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 50, 30, 20, 10 };
		System.out.println(countInversion(arr, arr.length));
	}
}
