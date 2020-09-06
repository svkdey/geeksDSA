package LeetCode;


import java.util.*;

public class LeetCode1441 {
	 public List<String> buildArray(int[] target, int n) {
	        HashSet<Integer> set=new HashSet<Integer>();
	        ArrayList<String> ans=new ArrayList<>();
	        int max=0;
	        for(int x:target) {
	        	set.add(x);
	        	max=Math.max(max, x);
	        }
	        for(int i=1;i<=max;i++) {
	        	ans.add("Push");
	        	if(!set.contains(i)) {
	        		ans.add("Pop");
	        	}
	        }
	        return ans;
	    }
}
