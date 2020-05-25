package GraphAlgorithm;

import Data.GraphData;

import java.util.*;

// o(V+E)
public class ShortestPathInUnweightedGraph {
    //Note BFS always traverse a path in shortest path manner
    public static void findAllTheShortestPathLengthInUnweightedGraph(ArrayList<ArrayList<Integer>> adjList, int source, int numberOfVertex) {
        HashSet<Integer> set = new HashSet<>();
        int distance[] = new int[numberOfVertex];

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        set.add(source);
        while (!q.isEmpty()) {
            Integer vertex = q.remove();
            ArrayList<Integer> list = adjList.get(vertex);

            for (int v : list) {
                if (!set.contains(v)) {
                    //distance  v= source to closest vertex+1

                    distance[v] = distance[vertex] + 1;
                    set.add(v);
                    q.add(v);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        GraphAdjacencyList g2 = GraphData.getGraph();
        System.out.println(g2.adjList);
        findAllTheShortestPathLengthInUnweightedGraph(g2.adjList, 0, g2.vertexList.size());

    }
}
