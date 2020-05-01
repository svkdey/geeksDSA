package Recursion;

public class GlobalMathFunctions {
	public static int factorial(int number) {
		if (number == 0)
			return 1;
		else {
			return number * factorial(number - 1);
		}
	}
	public static int Sum(int number) {
		if (number == 0)
			return 0;
		else {
			return number * Sum(number - 1);
		}
	}
	public static boolean isEven(int num) {
		return num%2==0;
	}
}
