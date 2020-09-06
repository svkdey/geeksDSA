package GraphQuickRecap;

import java.util.*;

public class TarjanTheorem {
    static int time = 0;

    public static void solve(ArrayList<ArrayList<Integer>> graph, int src, int discoverTime[], int lowTime[], int parent,Stack<Integer> stack) {
        discoverTime[src] = lowTime[src] = time++;
        stack.push(src);
        int number_of_child_src = 0;
        for (int child : graph.get(src)) {
            if (discoverTime[child] == 0) {
                solve(graph, child, discoverTime, lowTime, parent,stack);
                number_of_child_src++;
                lowTime[src] = Math.min(lowTime[child], lowTime[src]);

            } else if (child != parent) {
                //cycle is there. and as child is already discovered .we will try to see if we get minimum low time for source
                lowTime[src] = Math.min(lowTime[src], discoverTime[child]);
            }
        }

        StringBuffer br = new StringBuffer();
        if (lowTime[src] == discoverTime[src]) {
            while (!stack.isEmpty()) {
                int x = stack.pop();

                br.append(x + " ");
                if (x == src)
                    break;
            }
            System.out.println(br.toString().trim() + ",");
        }

    }

    public static void TarjanTheorem(ArrayList<ArrayList<Integer>> graph, int n) {
        int discoverTime[] = new int[n];
        int lowTime[] = new int[n];
        Stack<Integer> s=new Stack<>();
        time = 0;
        for (int i = 0; i < n; ++i) {
            if (discoverTime[i] == 0)
                solve(graph, i, discoverTime, lowTime, -1,s);
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyListDirectedGraph g=GraphData.getNoCycleDirectedGraph2();
        System.out.println(g);
        TarjanTheorem(g.adjList, g.adjList.size());
    }
}
