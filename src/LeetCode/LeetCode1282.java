package LeetCode;

import java.util.*;

public class LeetCode1282 {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		TreeMap<Integer, Queue<Integer>> map = new TreeMap<Integer, Queue<Integer>>();
		for (int i = 0; i < groupSizes.length; i++) {
			if (map.containsKey(groupSizes[i])) {
				Queue<Integer> q = map.get(groupSizes[i]);
				q.add(i);
				map.put(groupSizes[i], q);
			} else {
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(i);
				map.put(groupSizes[i], q);
			}
		}
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		for(int x:map.keySet()) {
		
			Queue<Integer> q = map.get(x);
			int s=q.size();
			int loop=s/x;
			for(int i=0;i<loop;i++) {
				List<Integer> subGrp=new ArrayList<Integer>();
				int k=x;
				while(!q.isEmpty()&&k!=0) {
					subGrp.add(q.remove());k--;
				}
				ans.add(subGrp);
			}
		}
		return ans;
	}
}
