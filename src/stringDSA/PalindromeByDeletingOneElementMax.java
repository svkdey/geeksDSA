package stringDSA;

public class PalindromeByDeletingOneElementMax {
	public boolean pali(String str, int l, int r) {
		if (str.length() == 1)
			return true;
		int s = l;
		int e = r;
		while (e > s) {
			if (str.charAt(s) != str.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
	// a b c b a it will break at l=1 r=2 so we need to check if (s,2,2) || (s,3,3) palindrome or not
	public boolean validPalindrome(String s) {
		if (s.length() <= 1)
			return true;

		int l = 0;
		int r = s.length() - 1;
		while (l <= r) {
			if (s.charAt(l) == s.charAt(r)) {
				l++;
				r--;
				
			} else {
				return pali(s, l, r - 1) || pali(s, l + 1, r);
			}
		}
		return true;

	}
}
