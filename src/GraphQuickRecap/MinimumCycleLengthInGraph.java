package GraphQuickRecap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumCycleLengthInGraph {
    public static void solve(int V, ArrayList<ArrayList<Integer>> adjList, int startNode) {
        Queue<Integer> q = new LinkedList<>();
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startNode] = 0;

        q.add(startNode);
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int src = q.remove();

                for (int child : adjList.get(src)) {
                    if (distance[child] == Integer.MAX_VALUE) {
                        q.add(child);
                        distance[child] = distance[src] + 1;
                    } else if (distance[child] >= distance[src]) {
                        ans = Math.min(ans, distance[src] + distance[child] + 1);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(distance));
    }
    public static void main(String[] args)
    {

        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

    }
}
