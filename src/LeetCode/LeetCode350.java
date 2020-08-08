package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode350 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		if (nums1.length > nums2.length) {
			for (int x : nums1) {
				map1.put(x, map1.getOrDefault(x, 0) + 1);
			}
			for (int x : nums2) {
				map2.put(x, map2.getOrDefault(x, 0) + 1);
			}
		} else {
			for (int x : nums2) {
				map1.put(x, map1.getOrDefault(x, 0) + 1);
			}
			for (int x : nums1) {
				map2.put(x, map2.getOrDefault(x, 0) + 1);
			}
		}
		for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
			if (map1.containsKey(e.getKey())) {
				map2.put(e.getKey(), Math.min(e.getValue(), map1.get(e.getKey())));
			} else {
				map2.put(e.getKey(), 0);
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
			for (int i = 0; i < e.getValue(); i++) {
				res.add(e.getKey());
			}
		}
		System.out.println(res);
		int ans[] = new int[res.size()];
		int i = 0;
		for (int x : res) {
			ans[i] = x;
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int nums1[] = {4,9,5};
		int nums2[] = {9,4,9,8,4};
		intersect(nums1, nums2);
	}

}
