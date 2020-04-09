package Playground;

public class DigitOfFactorial {
	public static int digitsInFactorial(int N) {
		double digits = 0;
		for (int i = 1; i <= N; i++) {
			digits += Math.log10((double)i);
		}
	         return (int)Math.floor(digits)+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-----------------------");
		System.out.println(digitsInFactorial(10));
	}

}
