package LeetCode.InterviewPrep;

import java.util.*;

public class SkyLineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		 List<int[]> criticalPoints=new ArrayList<int[]>();
		 List<int[]> ans=new ArrayList<int[]>();
		 for(int[] building:buildings) {
			 criticalPoints.add(new int[] {building[0],-building[2]});
			 criticalPoints.add(new int[] {building[1],building[2]});
		 }
		 Comparator<int[]> rule=(a,b)->{
			 if(a[0]==b[0]) {
				 return a[1]-b[1];
			 }return a[0]-b[0];
		 };
		 Collections.sort(criticalPoints,rule);
		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		 pq.add(0);
		 int prevHeight=0;
		 for(int i=0;i<criticalPoints.size();i++ ) {
			 if(criticalPoints.get(i)[1]<0) {
				 pq.add(-criticalPoints.get(i)[1]);
			 }
			 else if(criticalPoints.get(i)[1]>0) {
				 pq.remove(criticalPoints.get(i)[1]);
			 }
			 if(pq.peek()!=prevHeight) {
				 ans.add(new int[] {criticalPoints.get(i)[0],pq.peek()});
				 prevHeight=pq.peek();
			 }
		 }
		 return ans;
	}
}
