package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class LeetCode532 {
	public int[] removeDuplicateAndSorted(int[] nums) {
		TreeSet<Integer> s = new TreeSet<Integer>();
		for (int x : nums) {
			s.add(x);
		}
		int arr[] = new int[s.size()];
		int k = 0;
		for (int x : s) {
			arr[k++] = x;
		}
		return arr;
	}

	public int findPairs(int[] nums, int k) {
		if(k<0) {
			return 0;
		}
		if(k==0) {
			int ans=0;
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			for(int num:nums) {
				map.put(num,map.getOrDefault(num, 0)+1);
			}
			for(int x:map.keySet()) {
				if(map.get(x)%2==0) {
					ans++;
				}
			}
			return ans;
		}
		else {
			int ans=0;
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			for(int num:nums) {
				map.put(num,map.getOrDefault(num, 0)+1);
			}
			for(int x:map.keySet()) {
				int c=x-k;
				if(map.containsKey(c)) {
					ans++;
				}
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		LeetCode532 s = new LeetCode532();
		int arr[] = { 3, 1, 4, 1, 5 };
		s.findPairs(arr, 2);
	}
}
