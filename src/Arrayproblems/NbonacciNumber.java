package Arrayproblems;

public class NbonacciNumber {
	// o((m-n)n)
	public static void nBonacciNumber(int n, int m) {
		int[] arr = new int[100];
		create1stNterms(arr, n - 1);
		arr[n] = 1;
		for (int i = n + 1; i < m; i++) {
			int sum = 0;
			for (int j = i - n; j < i; j++) {
				sum += arr[j];
			}
			arr[i] = sum;
			System.out.println(arr[i]);
		}
	}

	// o(n)
	public static void nBonacciNumbertwo(int n, int m) {
//		0 0 0 0 1 1 2 4 8 16 31
		int[] arr = new int[100];
		create1stNterms(arr, n - 1);
		arr[n] = 1;
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += arr[i];
		}
		arr[n + 1] = sum;
		for (int i = n + 1; i < m; i++) {
			sum += arr[i] - arr[i - n];
			arr[i + 1] = sum;
			;
		}
		for (int i = 0; i < m; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void create1stNterms(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = 0;
		}
		arr[n] = 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nBonacciNumbertwo(5, 15);
	}

}
