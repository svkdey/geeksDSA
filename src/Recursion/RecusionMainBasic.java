package Recursion;

public class RecusionMainBasic {
	public static void checkPalindrome(String str) {
		int i = 0;
		int l = str.length() - 1;
		isPalindrome(str, i, l);

	}

	public static void isPalindrome(String s, int a, int b) {
		if (a >= b) {
			System.out.println(true);
		} else {
			if (s.charAt(a) == s.charAt(b)) {
				isPalindrome(s, a + 1, b - 1);
			} else {
				System.out.println(false);
			}
		}
	}

	public static int sumOfdigits(int num) {
		if (num == 0) {
			return 0;
		} else {
			return (num % 10) + sumOfdigits(num / 10);
		}
	}

	public static void main(String[] args) {
		checkPalindrome("abbca");
		System.out.println(sumOfdigits(253));

	}
}
