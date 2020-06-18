package Recursion.SubSet_Subsequence;

public class Knapsack01 {

	public static int solve(int values[], int wts[], int target, int n) {
		if (target <= 0) {
			return 0;
		}
		if (n <= 0) {
			return 0;
		}
		
		int including = 0;
		int exclude = 0;
		//including nth item
		if (wts[n - 1] <= target) {
			including = solve(values, wts, target - wts[n - 1], n - 1) + values[n - 1];
		}
		//excluding nth item
		exclude = solve(values, wts, target, n - 1);
		
		return Math.max(exclude, including);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int values[] = { 40, 20, 30, 100 };
		int wts[] = { 1, 2, 3, 5 };

		int N = 4;
		int C = 7;
	
		System.out.println(solve(values, wts, 7, N));

	}

}
