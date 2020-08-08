package LeetCode;

import java.util.ArrayList;

public class CelebrityProblem {
	public static void solve(int knows[][]) {
		int N = knows.length;
		ArrayList<ArrayList<Integer>> inDegreeList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> outDegreeList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < knows.length; i++) {
			inDegreeList.add(new ArrayList<Integer>());
			outDegreeList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < knows.length; i++) {
			for (int j = 0; j < knows[i].length; j++) {
				if (knows[i][j] == 1) {
					inDegreeList.get(i).add(j);
					outDegreeList.get(j).add(i);
				}
			}
		}

		int ans = -1;
		for (int i = 1; i < inDegreeList.size(); i++) {
			if (inDegreeList.get(i).size() == 0 && outDegreeList.get(i).size() == N - 1) {
				ans = i;
			}
		}
		System.out.println(ans);
//		System.out.println(inDegreeList);
//		System.out.println(outDegreeList);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

		int MATRIX2[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };

		solve(MATRIX);
	}

}
