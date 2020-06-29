package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode207 {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0)
			return false;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int x[] : prerequisites) {
			graph.get(x[0]).add(x[1]);
		}
		System.out.println(graph);
		boolean isVisited[] = new boolean[numCourses];
		boolean inStack[] = new boolean[numCourses];
		Stack<Integer> ans = new Stack<Integer>();
		boolean ifimPossible = false;
		for (int i = 0; i < numCourses; i++) {
			if (!isVisited[i] && dfs(graph, isVisited, inStack, ans, i, -1)) {
				ifimPossible = true;
				break;
			}
		}
		if (ifimPossible) {
			System.out.println("cycle");
		} else {
			System.out.println(ans);
		}

		return ifimPossible;
	}

	static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean isVisited[], boolean inStack[], Stack<Integer> ans,
			int src, int parent) {
		isVisited[src] = true;
		inStack[src] = true;
		for (int child : graph.get(src)) {
			if (!isVisited[child]) {
				boolean cycleMila = dfs(graph, isVisited, inStack, ans, child, src);

				if (cycleMila) {

					return true;
				}

			} else if (parent != child) {
				if (inStack[child]) {
					return true;
				}
			}
		}
		inStack[src] = false;
		ans.push(src);
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int couses[][] = { { 1, 0 }, { 0, 2 }, { 2, 3 }, { 3, 1 } };
		int n = 4;
		System.out.println(canFinish(n, couses));
	}

}
