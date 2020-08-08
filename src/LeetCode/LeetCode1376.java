package LeetCode;

import java.util.*;
//propaget Time
public class LeetCode1376 {
	static class Propgation{
		int head,time;

		public Propgation(int head, int time) {
			super();
			this.head = head;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Propgation [head=" + head + ", time=" + time + "]";
		}
		
	}
	
	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < manager.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < manager.length; i++) {
			if (i != headID) {
				graph.get(manager[i]).add(i);
			}
		}
		System.out.println(graph);
		int ans = dfs(headID, informTime[headID], graph, informTime);

		System.out.println(ans);
		return ans;
	}

	public static int dfs(int head, int ans, ArrayList<ArrayList<Integer>> graph, int[] informTime) {
		Queue<Propgation> q = new LinkedList<Propgation>();
		q.add(new Propgation(head, informTime[head]));
		int max = 0;
		while (!q.isEmpty()) {
			int s = q.size();
			
			for (int i = 0; i < s; i++) {
				Propgation node=q.remove();
				max = Math.max(max,node.time);
				
				
				for (int  child: graph.get(node.head)) {
					//propage in child
					q.add(new Propgation(child,informTime[child]+node.time));
				
				}
			}
			
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8, headID = 0, manager[] = { -1, 5, 0, 6, 7, 0, 0, 0 },
				informTime[] = { 89, 0, 0, 0, 0, 523, 241, 519 };
		numOfMinutes(n, headID, manager, informTime);
	}

}
