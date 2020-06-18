package Recursion;

public class BikePartyProblem {
	int bikingWays(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		// one goes alone ..so left ppl will go f(n-1 ) ways.
		// if couple goes one can choose other one guy in N-1^C1 ways*f(n-2);
		else
			return bikingWays(n - 1) + ((n - 1) * bikingWays(n - 2));
	}

	public static void solve() {

	}

	public static void main(String[] args) {

	}
}
