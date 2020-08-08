package DPrevised;

public class CatalanNumbers {
	/**
	 * catalan : 2nCn/(n+1);
	 * 
	 * 
	 * f(N)=Sum(f(i-1)*f(N-i)) where start_i=1;end_i=N
	 * 
	 * 
	 * 
	 * 
	 **/
	public static int nCr(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		} else {
			return nCr(n - 1, r - 1) + nCr(n - 1, r);
		}
	}

	public static int solve(int n) {
		return nCr(2*n, n)/(n+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(3));
	}

}
