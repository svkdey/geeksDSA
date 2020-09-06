package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode229 {
	public List<Integer> majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> l=new ArrayList<Integer>();
		for(int x:nums) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(int x:map.keySet()) {
			if(map.get(x)>(nums.length/3)) {
				l.add(x);
			}
		}
		return l;
	}

}
