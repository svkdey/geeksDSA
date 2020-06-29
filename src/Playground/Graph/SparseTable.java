package Playground.Graph;

import java.util.Arrays;

//vvi concept

//rangeBased query in log(n)
//Idempotent function o(1)
public class SparseTable {
	// we have tree DS .
	// we need matrix n=length or array m=Math.ceil(log2(n))+1
	// mat[i][j]=[i,i+Math.pow(2,j)-1] range value

	// sparse table for min value
	static class SparseTableImpl {
		int matrix[][] = null;

		int n, m = 0;

		@Override
		public String toString() {
			String s = "";
			for (int x[] : matrix) {
				s += Arrays.toString(x);
			}
			return "SparseTableImpl [matrix=" + s + ", n=" + n + ", m=" + m + "]";
		}

		public SparseTableImpl(int n) {
			super();

			this.n = n;
			this.m = (int) (Math.ceil(Math.log(n)) + 1);

			this.matrix = new int[n][m];

		}

		public void build(int arr[]) {
			for (int i = 0; i < n; i++) {
				matrix[i][0] = arr[i];
			}
			for (int j = 1; j <= m; j++) {
				for (int i = 0; i + (1 << j) <= n; i++) {
					// only change here the idempotent function
					int a = matrix[i][j - 1];
					int b = matrix[i + (1 << (j - 1))][j - 1];
					int ans = lcm(a, b);
					matrix[i][j] = ans;
				}
			}
		}

		public int query(int l, int r) {
			int j = (int) Math.log(r - l + 1);
			// only change here the idempotent function
			int a = matrix[l][j];
			int b = matrix[r - (1 << j) + 1][j];
			int ans = lcm(a, b);
			return ans;
		}

	}

	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	static int gcd(int a, int b) {
		if (b > a) {
			int t = a;
			a = b;
			b = t;
		}
		return findGCD(a, b);
	}

	static int findGCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return findGCD(b, a % b);
	}

	static int findSum(int a, int b) {
		return a + b;
	}

	static int findMin(int a, int b) {
		return Math.min(a, b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 7, 2, 3, 1, 5, 10, 3, 12, 18 };
		SparseTableImpl table = new SparseTableImpl(a.length);
		table.build(a);
		for(int x[]:table.matrix) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println(table.query(0, 2));
		System.out.println(table.query(1, 3));
		System.out.println(table.query(5, a.length-1));
		
	}

}
