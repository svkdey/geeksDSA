package GraphAlgorithm;

import Data.GraphData;

import java.util.*;

public class LevelOfNodes {
    static int levelOfGraph(ArrayList<ArrayList<Integer>> list, int x, int target) {

        HashMap<Integer, Integer> lvl = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited.add(x);
        lvl.put(x, 0);
        while (!q.isEmpty()) {
            int _v = q.remove();
            for (int v : list.get(_v)) {
                if (!visited.contains(v)) {
                    q.add(v);
                    visited.add(v);
                    lvl.put(v, lvl.get(_v) + 1);
                }
            }
        }
        return lvl.get(target);
    }


    public static void main(String[] args) {
        GraphAdjacencyList graph = GraphData.getNoCycleGraph();
        System.out.println(graph);
        levelOfGraph(graph.adjList, 0, 1);
    }
}
