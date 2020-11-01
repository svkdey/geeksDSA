package LeetCode.InterviewPrep;

public class CountPrimes {
	public int countPrimes(int n) {
		boolean numbers[] = new boolean[n + 1];
		for (int i = 2; i * i <= n; i++) {
			if (!numbers[i]) {
				int k = i;
				for (int j = 2; j * i <= n; j++) {
					numbers[i * j] = true;
				}
			}
		}
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (!numbers[i]) {
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		CountPrimes c=new CountPrimes();
		System.out.println(c.countPrimes(2));
	}
}
