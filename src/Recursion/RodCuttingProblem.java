package Recursion;

public class RodCuttingProblem {
	public static int rodCutting(int n, int a, int b, int c) {
		// base cases
		if (n == 0)
			return 0;
		if (n < 0)
			return -1;

		// recursion
		int res = Math.max(Math.max(rodCutting(n - c, a, b, c), rodCutting(n - a, a, b, c)),
				rodCutting(n - b, a, b, c));
		// result of recusion if -1 no solution
		if (res == -1)
			return -1;
		// else return this.
		else
			return 1 + res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 25;
		int a = 5, b = 10, c = 4;
		System.out.println(rodCutting(n, a, b, c));
	}

}
