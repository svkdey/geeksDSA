package stringDSA;

public class KMNalgorithm {
	static int longestPrefixVal(String str, int n) {
		for (int len = n - 1; len > 0; len--) {
			boolean flag = true;
			for (int i = 0; i < len; i++) {
				if (str.charAt(i) != str.charAt(n - len + i)) {
					flag = false;
				}
			}
			if (flag == true)
				return len;
		}
		return 0;
	}

	public static int[] findLongestProperPrefixSuffixSubarray(String str) {
		int[] arr = {};
		for (int i = 0; i < str.length(); i++) {
			arr[i] = longestPrefixVal(str, i + 1);
		}
		return arr;
	}
	/*
	 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
	 */

	public static int[] findLongestProperPrefixSuffixSubarrayMethod2(String str) {
		int[] lps = new int[str.length()];
		int n = str.length(), len = 0;
		lps[0] = 0;
		int i = 1;
		while (i < n) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len == 0) {
					lps[i] = 0;
					i++;

				} else {
					len = lps[len - 1];
				}
			}
		}
		return lps;

	}

	public static void kmpImpl(String text, String ptr) {
		int[] lps = findLongestProperPrefixSuffixSubarrayMethod2(ptr);
		int i = 0, j = 0, N = text.length(), M = ptr.length();

		while (i < N) {
			if (ptr.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if (j == M) {
				System.out.println(i - j);
				j = lps[j - 1];

			} else if (i < N && ptr.charAt(j) != text.charAt(i)) {
				if (j == 0) {
					i++;
				} else {
					j = lps[j - 1];
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		findLongestProperPrefixSuffixSubarrayMethod2("abacabad");

		kmpImpl("ABABCA", "BA");
	}

}
