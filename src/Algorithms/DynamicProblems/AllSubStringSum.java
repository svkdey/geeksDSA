package Algorithms.DynamicProblems;

public class AllSubStringSum {
	public static long sumSubstrings(String s) {
		// Your code here
		int sum = 0;
		for (int i = 0; i <= s.length() - 1; i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				System.out.println(s.substring(i, j));
				sum += Integer.parseInt(s.substring(i, j));
			}

		}
//		System.out.println(sum);
		return sum;
	}

//	Linear time equation
	/**
	 * We can write summation of all substrings on basis of digit at which they are
	 * ending in that case, Sum of all substrings = sumofdigit[0] + sumofdigit[1] +
	 * sumofdigit[2] … + sumofdigit[n-1] where n is length of string.
	 * 
	 * Where sumofdigit[i] stores sum of all substring ending at ith index digit, in
	 * above example,
	 * 
	 * Example : num = "1234" sumofdigit[0] = 1 = 1 sumofdigit[1] = 2 + 12 = 14
	 * sumofdigit[2] = 3 + 23 + 123 = 149 sumofdigit[3] = 4 + 34 + 234 + 1234 = 1506
	 * Result = 1670 Now we can get the relation between sumofdigit values and can
	 * solve the question iteratively. Each sumofdigit can be represented in terms
	 * of previous value as shown below,
	 * 
	 * For above example, sumofdigit[3] = 4 + 34 + 234 + 1234 = 4 + 30 + 4 + 230 + 4
	 * + 1230 + 4 = 4*4 + 10*(3 + 23 +123) = 4*4 + 10*(sumofdigit[2]) In general,
	 * sumofdigit[i] = (i+1)*num[i] + 10*sumofdigit[i-1]
	 **/
	public static long sumSubstringsDP(String s) {
		// Your code here

		// Your code here
		long dp[] = new long[s.length()];

		String s1 = "" + s.charAt(0);
		dp[0] = Integer.parseInt(s1);
		long sum = dp[0];
		for (int i = 1; i < s.length(); i++) {
			String s2 = "" + s.charAt(i);
			long numIth = Integer.parseInt(s2);

			dp[i] = ((i + 1) * numIth) % 1000000007 + (10 * dp[i - 1]) % 1000000007;
			dp[i] = dp[i];
			sum = (sum + dp[i]) % 1000000007; // take modulo with 10^9+7 here as well
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sumSubstringsDP("1234");
	}

}
