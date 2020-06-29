package Playground.Graph;

import java.util.Arrays;

public class TravellingSalesManProblem {
	// hamiltonian cycle -> vertex->all vertex->return to that vertex where started
	// is called hamiltonian cycle

	// mini distance travelled this way is the answer

	// np hard problem.

	// dynamic problem (top down dp)

	/**
	 * 000000 ->initial FEDCBA suppose ->A taken 000001 FEDCBA 00101->choosen FEDCBA
	 * BitMaskingSolution() base case->when all 111111 if we find direct edge to go
	 * to source. that's solution
	 *
	 * complexity (n(n-1)!)
	 **/
	
	
	
	
	
	static int graph[][] = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };

	static int n = graph.length;
	static int m = graph[0].length;

	static int VISISTED_ALL = (1 << n) - 1;

	public static void solve() {
		System.out.println(tsp(1, 0));
	}

	static int dp[][] = new int[(int) Math.pow(2, n)][n];

	public static int tsp(int mask, int pos) {
		if (mask == VISISTED_ALL) {
			return graph[pos][0];
		}
		if (dp[mask][pos] != -1) {
			return dp[mask][pos];
		}
		int ans = Integer.MAX_VALUE;
		for (int city = 0; city < n; city++) {
			// if we find unmask position we will take that and move on
			if ((mask & (1 << city)) == 0) {
				// mask the position
				int newAns = graph[pos][city] + tsp((mask | (1 << city)), city);
				ans = Math.min(ans, newAns);
				// saving the state
				dp[mask][city] = ans;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		solve();

	}

}
