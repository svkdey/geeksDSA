package Sorting;

public class SortedSetOpertations {
	// naive
	static void intersection(int arr[], int arr2[]) {
		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && arr[i - 1] == arr[i]) {
				continue;
			}
			for (int j = 0; j < arr2.length; j++) {
				if (arr[i] == arr2[j]) {
					System.out.println(arr[i]);
				}
			}
		}
	}

//	o(m+n)
	static void intersection1(int a[], int b[]) {
		int n = a.length;
		int m = b.length;
		int i = 0, j = 0;

		while (i < n && j < m) {
			// skipping element already exist
			if (i > 0 && a[i - 1] == a[i]) {
				i++;
				continue;
			}
			if (a[i] < b[j]) {
				i++;
			} else if (b[j] < a[i]) {
				j++;
			} else {
				System.out.println(a[i]);
				i++;
				j++;
			}

		}

	}

	static void union(int a[], int b[]) {
		int n = a.length;
		int m = b.length;
		int i = 0, j = 0;

		while (i < n && j < m) {
			// skipping element already exist
			if (i > 0 && a[i - 1] == a[i]) {
				i++;
				continue;
			}
			if (j > 0 && b[j - 1] == b[j]) {
				j++;
				continue;
			}
			if (a[i] < b[j]) {
				System.out.println(a[i]);
				i++;
			} else if (a[i] > b[j]) {
				System.out.println(b[j]);
				j++;
			} else {
				System.out.println(a[i]);
				i++;
				j++;
			}

		}
		while (i < n) {
			System.out.println(a[i]);
			i++;

		}
		while (j < m) {
			System.out.println(b[j]);
			j++;

		}
	}

	static void union2(int arr[], int arr2[]) {

	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 7 };
		int arr1[] = { 1, 2, 6, 9, 11 };
		union(arr, arr1);
	}
}
