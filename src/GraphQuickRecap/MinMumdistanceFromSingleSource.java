package GraphQuickRecap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinMumdistanceFromSingleSource {
    public static int solve(ArrayList<ArrayList<Integer>> graph, int n, int src, int dest) {
        //count inDegree

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        q.add(src);
        //now do the BFS
        int dist = 0;
        while (!q.isEmpty()) {
            dist++;
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int v = q.remove();
                for (int ancestor : graph.get(v)) {
                    if (!visited[ancestor]) {
                        q.add(ancestor);
                        visited[ancestor] = true;
                        if (ancestor == dest) {
                            return dist;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
