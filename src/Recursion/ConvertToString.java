package Recursion;

public class ConvertToString {
	static String mp[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	void getNumber(int n) {
		if (n == 0)
			return;
		int val = n % 10;
		n = n / 10;
		getNumber(n);
		System.out.println(mp[val]);
		return;

	}

	void printNumber(int number) {

		getNumber(number);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
