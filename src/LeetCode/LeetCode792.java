package LeetCode;

import java.util.Arrays;

public class LeetCode792 {
	public int numMatchingSubseq(String S, String[] words) {
		int lenS = S.length();

		
		
		int ans = 0;
		for (String x : words) {
		
			int subsequenceLen=isSubsequenceImpl(x, S,  x.length(),S.length());
			if (x.length() == subsequenceLen) {
				ans++;
			}
		}
		return ans;
	}



	public int isSubsequenceImpl(String s, String t, int n, int m) {
		int ans=0;
		while(m!=0&&n!=0) {
			if(s.charAt(n-1)==t.charAt(m-1)) {
				m--;n--;ans++;
			}
			else {
				m--;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String S = "abcde",words[] = {"a", "bb", "acd", "ace"};
		LeetCode792 solve=new LeetCode792();
		System.out.println(solve.numMatchingSubseq(S, words));
	}
}
