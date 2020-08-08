package LeetCode;

public class LeetCode38 {
	public int addDigits(int num) {
		return util(Integer.toString(num));
	}

	public int util(String num) {
		if (num.length() == 1) {
			return Integer.parseInt(num);
		}
		char c[] = num.toCharArray();
		int sum = 0;
		for (char x : c) {
			sum += x - '0';
		}
		return util(Integer.toString(sum));
	}
	public static void main(String[] args) {
		LeetCode38 s=new LeetCode38();
		System.out.println(s.addDigits(38));
	}
}
