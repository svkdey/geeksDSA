package LeetCode;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode373 {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Comparator<ArrayList<Integer>> rule = (a, b) -> {
			return (a.get(0) + a.get(1)) - (b.get(0) + b.get(1));
		};
		PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<ArrayList<Integer>>(rule);
		for(int i=0;i<nums1.length;i++) {
			for(int j=0;j<nums2.length;j++) {
				ArrayList<Integer> l=new ArrayList<Integer>();
				l.add(nums1[i]);l.add(nums2[j]);
				pq.add(l);
			}
		}
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		while(!pq.isEmpty()&&k!=0) {
			k--;
			ans.add(pq.remove());
		}
		return ans;
	}
}
