package GraphQuickRecap;

import java.util.ArrayList;

public class ArticulationPoint {
    static int time = 0;

    public static void solve(ArrayList<ArrayList<Integer>> graph, int src, int discoverTime[], int lowTime[], int parent) {
        discoverTime[src] = lowTime[src] = time++;

        int number_of_child_src = 0;
        for (int child : graph.get(src)) {
            if (discoverTime[child] == 0) {
                solve(graph, child, discoverTime, lowTime, parent);
                number_of_child_src++;
                lowTime[src] = Math.min(lowTime[child], lowTime[src]);


                //articulation point
                // ie not root but low time[child]>=discovery[root]
                if (parent != 0 && lowTime[child] >= discoverTime[src]) {
                    System.out.println("Articulation point :" + src);
                }

                // ie  low time[child]>discovery[root]
                if (lowTime[child] > discoverTime[src]) {
                    System.out.println("bridge point :" + src + " " + child);
                }
            } else if (child != parent) {
                //cycle is there. and as child is already discovered .we will try to see if we get minimum low time for source
                lowTime[src] = Math.min(lowTime[src], discoverTime[child]);
            }
        }

        if (parent == -1 && number_of_child_src >= 2) {
            System.out.println(src);
        }
    }

    public static void articulationPoint(ArrayList<ArrayList<Integer>> graph, int n) {
        int discoverTime[] = new int[n];
        int lowTime[] = new int[n];
        time = 0;
        for (int i = 0; i < n; ++i) {
            if (discoverTime[i] == 0)
                solve(graph, i, discoverTime, lowTime, -1);
        }
    }

}
