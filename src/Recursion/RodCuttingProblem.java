package Recursion;

public class RodCuttingProblem {
	public static int rodCutting(int n, int a, int b, int c) {
		if (n == 0)
			return 0;
		if (n < 0)
			return -1;
		int res = Math.max(Math.max(rodCutting(n - c, a, b, c), rodCutting(n - a, a, b, c)),
				rodCutting(n - b, a, b, c));
		if (res == -1)
			return -1;
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
