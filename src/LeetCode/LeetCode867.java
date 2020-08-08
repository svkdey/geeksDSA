package LeetCode;

public class LeetCode867 {
	public int[][] transpose(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int ans[][] = new int[m][n];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				ans[j][i] = A[i][j];
			}
		}
		return ans;
	}
}
