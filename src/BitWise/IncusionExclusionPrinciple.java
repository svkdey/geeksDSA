package BitWise;

import java.util.ArrayList;

/**
 * find the numbers are divisible by nums under 1000 nums=[2,3,5,7,11,13,17.19]
 * generate subset of nums
 * 
 * basically set  opt
 * AUB =A + B if disconnected
 * 
 * AUB =A + B-(a intersection b)
 * 
 * a U b U c U d =
 *  
 */
public class IncusionExclusionPrinciple {
	private static ArrayList<Integer> filter(int n, int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int j = 0;
		while (n > 0 && j < arr.length) {
			int l_bit = (n & 1);

			if (l_bit == 1) {
				list.add(arr[j]);
			}
			n = n >> 1;
			j++;
		}

		return list;
	}

	public static long numberOfFactoer(int range, ArrayList<Integer> a) {
		if (a.size() == 0)
			return (long) 0;
		int divistor = 1;
		for (int x : a) {
			divistor *= x;
		}
//		System.out.println("divisor :" + divistor);
		if (a.size() % 2 == 0) {
			return (long) ((-1) * Math.floor(range / divistor));
		} else {
			return (long) (Math.floor(range / divistor));
		}
	}

	public static void solve(int nums[], int range) {
		int subset = (int) Math.pow(2, nums.length);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= subset; i++) {
			list.add(filter(i, nums));
		}
		long ans = 0;
		System.out.println(list);
		for (ArrayList<Integer> a : list) {
			long no_offactor = numberOfFactoer(range, a);
//			System.out.println("no_offactor  " + no_offactor);
//			if (no_offactor > 0) {
				ans += no_offactor;
//			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		int a[] = { 2,3 };
		solve(a, 6);
	}
}
