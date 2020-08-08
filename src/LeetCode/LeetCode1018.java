package LeetCode;

import java.util.*;

public class LeetCode1018 {
	public static List<Boolean> prefixesDivBy5(int[] A) {
		int nums[] = new int[A.length];
		nums[0] = A[0] * (int) Math.pow(2, 0);
		ArrayList<Boolean> ans = new ArrayList<Boolean>();
		ans.add(((nums[0] % 5) == 0));
		for (int i = 1; i < A.length; i++) {
			nums[i] = nums[i - 1] + A[i] * (int) Math.pow(2, i);
			ans.add((nums[i] % 5) == 0);
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]= {0,1,1};
		prefixesDivBy5(A);
		System.out.println("011");
	}

}
