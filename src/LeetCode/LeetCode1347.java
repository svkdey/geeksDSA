package LeetCode;

public class LeetCode1347 {
	public int minSteps(String s, String t) {
		int count[] = new int[256];
		for (char c : s.toCharArray()) {
			count[(int) c]++;
		}

		for (char c : t.toCharArray()) {
			if (count[(int) c] > 0) {
				count[(int) c]--;
			}
		}
		
		int ans=0;
		for(int i=0;i<256;i++) {
			ans+=count[i];
		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
