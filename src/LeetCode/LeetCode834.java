package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
/*
1. We need to know:
1.1 For each node i, which nodes are connected to it. So we create an ArrayList tree. 
tree.get(0) is a set of all the nodes connected to node 0, and tree.get(1) is all 
nodes connected to node 1, and so on. After iterating the edges array, we can 
initialize the tree list.
1.2 How many nodes are in one subtree with root node i. So we create a count array. 
1.3 Sum of distance from node i. So we create a res array, which is the result array 
we return.
2. In postDFS, we get 
1) number of nodes of subtree root(including root), (count array)
2) the sum distances from root to all its children nodes (res array)
                       1 ---------- count: 1 + 4 + 1 = 6
                     /   \          res: 1 + 0 + 4 + 4 = 9
                    /     \
        count: 1 - 2       3 ------ count: 1 + 2 + 1 = 4
        res: 0           /   \      res: 1 + 0 + 2 + 1 = 4
                        /     \  
        count: 1 ----- 4       5 -- count: 1 + 1 = 2
        res: 0                  \   res: 1 + 0 = 1
                                 \  
                                  6 count: 1
                                    res: 0
3. In preDFS, we do res[i] = res[root] - count[i] + count.length - count[i].
After step2, the res at root 1 is correct. But at other nodes, it counts only the distance
from subtrees. Now we move the node from 1 to other nodes, for example, to 2. There is
x nodes (x is the count number at 2) which are 1 step closer to 2 than to 1, and 
N - x nodes are 1 step farther to 2 than to 1. For example, at node 5. There are 
x nodes (x is the count number at 5) which are 1 step closer to 5 than to 3, and
N - x nodes are 1 step farther to 5 than to 3. So it is:
res[i] = res[root] + (- 1 * count[i]) + (1 * count.length - count[i]).
     	                     1 ---------- count: 6
    	                   /   \          res: 9
    	                  /     \
count: 1 --------------- 2       3 ------ count: 4
res: 9 - 1 + 6 - 1 = 13         /   \      res: 9 - 4 + 6 - 4 = 7
                               /     \  
count: 1 -------------------- 4       5 -- count: 2
res: 7 - 1 + 6 - 1 = 11                \   res: 7 - 2 + 6 - 2 = 9
                                        \  
                                         6 count: 1
                                           res: 9 - 1 + 6 - 1 = 13
*/


public class LeetCode834 {
	static int distance = 0;
	static int[] dp, count; //count ==for each node number of subtree count ,dp total distance

	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		dp = new int[N];
		 count= new int[N];
		ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<Integer>());

		}
		for (int[] edge : edges) {
			tree.get(edge[0]).add(edge[1]);
			tree.get(edge[1]).add(edge[0]);
		}

		boolean visit[] = new boolean[N];

		dfs1(tree, 0, visit);
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(count));
		 visit = new boolean[N];
		 dfs2(tree, 0, visit);
		return dp;
	}

	public void dfs1(ArrayList<ArrayList<Integer>> tree, int src, boolean visited[]) {
		visited[src] = true;

		for (int child : tree.get(src)) {
			if (!visited[child]) {
				dfs1(tree, child, visited);
				count[src] += count[child];
				dp[src] += dp[child] + count[child];
			}
		}
		count[src]++;
	}
	public void dfs2(ArrayList<ArrayList<Integer>> tree, int src, boolean visited[]) {
		visited[src] = true;

		for (int child : tree.get(src)) {
			if (!visited[child]) {
				
				dp[child] = dp[src] - count[child] + count.length - count[child];
				dfs2(tree, child, visited);
			}
		}
		
	}

	public static void main(String[] args) {
		LeetCode834 s = new LeetCode834();
		int N = 6, edges[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
		System.out.println(Arrays.toString(s.sumOfDistancesInTree(N, edges)));
	}
}
