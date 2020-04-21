package Searching;

public class FindSqrtOfNumber {
	public static int findSqrtOfNumber(int num) {
		// TODO Auto-generated method stub
		if (num == 0 || num == 1)
			return num;
		int start = 1;
		int end = num;
		int res=0;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (mid * mid == num) {
				return mid;
			}
			if (mid * mid < num) {
				start = mid + 1;

			} else {
				end = mid - 1;
			}
			res = mid;
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSqrtOfNumber(16));
	}

}
