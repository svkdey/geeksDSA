package Algorithms.GreedyBasic;

//https://www.spoj.com/problems/BALIFE/
public class LoadBalancing {

	private static int sum(int arr[]) {
		int sum = 0;
		for (int x : arr) {
			sum += x;
		}
		return sum;
	}

	public static void solve(int arr[], int n) {
		int s = sum(arr);
		float lpD= (float)s / n;
		int lpI = s / n;
	
		if (lpD != lpI) {
			System.out.println(-1);
			return;
		}
		
		int prefixArr[] = new int[n];
		prefixArr[0] = lpI;

		for (int i = 1; i < n; i++) {
			prefixArr[i] = prefixArr[i - 1] + lpI;
		}
		int maxMove = Integer.MIN_VALUE;
		int moves = 0;
		for (int i = 0; i < n; i++) {
			moves += arr[i];
			maxMove = Math.max(maxMove, Math.abs(prefixArr[i] - moves));
		}
		System.out.println(maxMove);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int loads1[] = { 49, 50 };

		int loads2[] = { 0, 99, 3 };

		int loads3[] = { 16, 17, 15, 0, 20, 1, 1, 2 };
		solve(loads1, loads1.length);

		solve(loads2, loads2.length);
		solve(loads3, loads3.length);

	}

}
