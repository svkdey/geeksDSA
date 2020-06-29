package LeetCode;

public class LeetCode256 {
	public static int nthUglyNumber(int n) {
		int i = 1;
		int ans = 1;
		while (i < n) {
			ans++;
			while ((ans% 2 == 0) || (ans %3 == 0 )|| (ans %5 == 0)) {
				ans++;
				i++;
			}
			
		}
		return ans-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(10));
	}

}
