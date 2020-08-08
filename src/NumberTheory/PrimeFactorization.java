package NumberTheory;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorization {
	public static void solve(int N) {
		int rootVal = (int) Math.sqrt(N);
		ArrayList<Integer> multiplers = new ArrayList<Integer>();
		boolean isPrime[] = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i; j * i <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if (isPrime[i] == true) {
				if (N % i == 0) {
					int ans = 0;
					while (N % i == 0) {
						N = N / i;
						ans++;
					}
					multiplers.add(ans);
					System.out.println(i + "^" +(ans));
				}
			}
		}
		System.out.println("number of divisor :");
		int divisorNumber=1;
		for(int x:multiplers) {
			divisorNumber*=(x+1);
		}
		System.out.println(divisorNumber);
	}

	public static void main(String[] args) {
		solve(60);
		//2 4 5 20 10 50 25 1 100
	}

}
