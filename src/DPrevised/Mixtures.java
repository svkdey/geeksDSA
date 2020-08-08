package DPrevised;

import java.util.Arrays;

//it is spoj problem
//f(i,j)=f(i,k)+f(k+j)+cSum(i,k)+cSum(k+1,j)
public class Mixtures {
	private static int sum(int s, int e) {
		int sum = 0;
		for (int i = s; i <= e; i++) {
			sum += ip[i];
			
		}
		return sum%100;
	}

	static int hash[][] = new int[1000][1000];
	static int ip[] = { 40, 60, 20 };

	public static int mcm(int i, int j) {

		if (i == j) {
			hash[i][j] = 0;
			return 0;
		}

		if (hash[i][j] != -1) {
			return hash[i][j];
		}

		int result = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = mcm(i, k) + mcm(k + 1, j) + (sum(i, k) * sum(k + 1, j));
			result = Math.min(result, temp);
		}

		hash[i][j] = result;
		return result;

	}


	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			Arrays.fill(hash[i], -1);
		}
		System.out.println(mcm(0, ip.length - 1));
	}
}
