package LeetCode;

import java.util.ArrayList;

public class LeetCode997 {

	public static int solve(int N, int trusts[][]) {
		ArrayList<ArrayList<Integer>> inDegreeList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> outDegreeList = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < N + 1; i++) {
			inDegreeList.add(new ArrayList<Integer>());
			outDegreeList.add(new ArrayList<Integer>());
		}
		for (int trust[] : trusts) {
			inDegreeList.get(trust[0]).add(trust[1]);
			outDegreeList.get(trust[1]).add(trust[0]);
		}
		System.out.println(inDegreeList);
		System.out.println(outDegreeList);
		int ans=-1;
		for(int i=1;i<inDegreeList.size();i++) {
			if(inDegreeList.get(i).size()==0&&outDegreeList.get(i).size()==N-1) {
				ans=i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int trusts[][] = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		System.out.println(solve(4, trusts));
	}
}
