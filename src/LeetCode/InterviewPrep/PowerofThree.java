package LeetCode.InterviewPrep;

public class PowerofThree {
	public static boolean isPowerOfThree(int n) {

		if ((double) (Math.log10(n) / Math.log10(3)) == (int) (Math.log10(n) / Math.log10(3))) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(244));
	}
}
