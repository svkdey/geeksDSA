package NumberTheory;

import java.util.Arrays;
//o(nlog log n)
public class PrimeSieve {
//	find all primes in range 1 to N
	/**
	 * for(int i to n){ if(prime(i)){ ... do your work
	 * 
	 * } } prime(N){ for(i to root(N)){ N%i==0? not prime : prime }
	 * 
	 * }
	 **/

	public static void solveByPrimeSieve(int n) {
		// TODO Auto-generated method stub
		boolean isPrime[] = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			isPrime[i] = true;
		}
		
		for (int factor = 2; factor<= Math.sqrt(n); factor++) {

            // if factor is prime, then mark multiples of factor as non prime
            // suffices to consider multiples factor, factor+1, ...,  n/factor
			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[j*factor] = false;
				}
			}
		}
		for(int  i=0;i<n;i++) {
			if(isPrime[i]==true) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(isPrime));
	}
	

	public static void main(String[] args) {
		solveByPrimeSieve(10000);
	}
}
