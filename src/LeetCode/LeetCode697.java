package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode697 {
	static class Range{
		int x,y;

		@Override
		public String toString() {
			return "Range [x=" + x + ", y=" + y + "]";
		}

		public Range(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static int solve(int nums[]) {
		if(nums.length==0) return 0;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		HashMap<Integer,Range> range=new HashMap<Integer, Range>();
		int maxFrequecy=0;
		for(int i=0;i<nums.length;i++) {
			int x=nums[i];
			if(map.containsKey(nums[i])) {
				map.put(x, map.get(x)+1);
				Range r=range.get(x);
				r.y=i;
				range.put(x, r);
			}else {
				map.put(x,1);
				range.put(x, new Range(i, i));
				
			}
			
			
			maxFrequecy=Math.max(maxFrequecy, map.get(x));
			
		}
		ArrayList<Integer> keyList=new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> x:map.entrySet()) {
			if(x.getValue()==maxFrequecy) {
				keyList.add(x.getKey());
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int x:keyList) {
			Range r=range.get(x);
			ans=Math.min(ans, r.y-r.x+1);
		}
		System.out.println(ans);
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,1,2};
		solve(a);
	}

}
