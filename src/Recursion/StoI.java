package Recursion;

public class StoI {
	void getNumber(String s, int n, int i, int sum) {
		if (n == s.length())
			return;

		getNumber(s, n + 1, i - 1, sum);

		sum += 1 * Math.pow(10, i) * (s.charAt(n) - '0');

		return;

	}

	void printNumber(int number) {
		int sum = 0;

		getNumber("1234", 0, 3, sum);
		System.out.println(sum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
