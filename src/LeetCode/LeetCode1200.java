package LeetCode;

import java.util.*;

public class LeetCode1200 {
	class Difference{
		ArrayList<Integer> l=null;
		int diff=0;
		@Override
		public String toString() {
			return "Difference [l=" + l + ", diff=" + diff + "]";
		}
		public Difference(ArrayList<Integer> l, int diff) {
			super();
			this.l = l;
			this.diff = diff;
		}
		
	}
	 public List<List<Integer>> minimumAbsDifference(int[] arr) {
		 	Comparator<Difference> rule=(a,b)->{
		 			if(a.diff==b.diff){
                    return a.l.get(0)-b.l.get(0);
                }else{
                    return a.diff-b.diff;
                }
		 	};
	        PriorityQueue<Difference> pq = new PriorityQueue<Difference>();
	        int minabs=Integer.MAX_VALUE;
	        for(int i=0;i<arr.length;i++) {
	        	for(int j=i+1;j<arr.length;j++) {
	        		int d=Math.abs(arr[i]-arr[j]);
	        		minabs=Math.min(minabs,d);
	        		ArrayList<Integer> l=new ArrayList<Integer>();
	        		l.add(arr[i]);
	        		l.add(arr[j]);
	        		pq.add(new Difference(l, d));
	        	}
	        }
	        System.out.println(pq);
	        List<List<Integer>> ans=new ArrayList<List<Integer>>();
	        while(!pq.isEmpty()&&pq.peek().diff>minabs) {
	        	ans.add(pq.remove().l);
	        }
	        Comparator<List<Integer>> rule2=(a,b)->{
		 		return a.get(0)-b.get(0);
		 	};
	        return ans;
	    }
}
