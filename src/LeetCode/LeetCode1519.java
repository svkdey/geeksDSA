package LeetCode;

import java.util.*;

public class LeetCode1519 {
	static class Node {
		Character lebel;
		ArrayList<Integer> l;

		public Node(Character lebel, ArrayList<Integer> l) {
			this.lebel = lebel;
			this.l = l;
		}

		@Override
		public String toString() {
			return "Node{" + "lebel=" + lebel + ", l=" + l + '}';
		}
	}

	public int[] countSubTrees(int n, int[][] edges, String labels) {
		ArrayList<Node> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char c = labels.charAt(i);
			graph.add(new Node(c, new ArrayList<>()));
		}
		for (int edge[] : edges) {
			graph.get(edge[0]).l.add(edge[1]);
		}
		int ans[] = new int[n];
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		Arrays.fill(ans, -1);
		for (int i = 0; i < n; i++) {
					
			if (ans[i] == -1) {
				dfs(graph, i, ans, 1,map,-1);
				System.out.println(Arrays.toString(ans));
			}
		}
		return ans;
		
	}

	public HashMap<Character, Integer> dfs(ArrayList<Node> graph, int src, int[] ans, int count,	HashMap<Character, Integer> map,int parent) {
		Node n = graph.get(src);
		
		for (int vetex : n.l) {
			Node p = graph.get(vetex);
			if (p.lebel == n.lebel) {

				HashMap<Character,Integer> temp =	dfs(graph, vetex, ans,count,map,src);
				  for(Map.Entry<Character, Integer> entry: temp.entrySet()){
                      map.put(entry.getKey(), map.getOrDefault(entry.getKey(),0)+entry.getValue());
                  }
					
			}
		}
		
		
		ans[src]=map.get(n.lebel);
		return map;
	}
}
