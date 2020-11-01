package exam;

public class Exam1 {
	public static String getShiftedString(String s, int leftShifts, int rightShifts) {
		// Write your code here
		if (s.isEmpty())
			return s;
		int totalShift = (rightShifts - leftShifts) % s.length();
		char carr[] = s.toCharArray();
		if (totalShift > 0) {
			rotateRight(carr, totalShift);
		} else if (totalShift < 0) {
			rotateLeft(carr, Math.abs(totalShift));
		}
		StringBuilder sb=new StringBuilder();
		for(char x:carr) {
			sb.append(x);
		}
		return sb.toString();
	}

	public static void reverse(char arr[], int i, int j) {
		int s = i;
		int e = j;
		while (e >= s) {
			char t = arr[s];
			arr[s] = arr[e];
			arr[e] = t;
			e--;
			s++;
		}
	}

	public static void rotateRight(char[] nums, int k) {
		if (nums.length < 1)
			return;
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);

		reverse(nums, 0, k - 1);

		reverse(nums, k, nums.length - 1);

	}

	public static void rotateLeft(char[] nums, int k) {
		if (nums.length < 1)
			return;
		k = k % nums.length;
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);

	}
	public static void main(String[] args) {
		System.out.println(getShiftedString("abcd", 3, 2));
	}

}
