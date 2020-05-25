package GraphAlgorithm;

import Data.GraphData;

import java.util.ArrayList;
import java.util.HashSet;
/**
 Application of DFS
     cycle detection
     Topological sorting
     strongly connected components
     solving maze and puzzel
     path finding

 **/

//o(v+e)
public class DFS {
    public static void DFSconnectedGraphImpl(ArrayList<ArrayList<Integer>> adjList, int source) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        DFSGraphImplHelper(adjList, source, result, set);
        System.out.println(result);
    }

    public static void DFSGraphImplHelper(ArrayList<ArrayList<Integer>> adjList, int source, ArrayList<Integer> result, HashSet<Integer> set) {
        //adding source in visited list.
        set.add(source);
        //adding source in result
        result.add(source);

        //retrieving all the vertex connected to source
        ArrayList<Integer> list = adjList.get(source);

        //looping all vertex and recursively calling DFSconnectedGraphImplHelper for unvisited vertex
        for (Integer v : list) {
            if (!set.contains(v)) {
                DFSGraphImplHelper(adjList, v, result, set);
            }
        }
    }
    //same concept as bfs
    public static void DFSDisconnectedGraphImpl(ArrayList<ArrayList<Integer>> adjList, int numberOfVertex) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        int numberOfConnectedComponent=0;
        for (int i = 0; i <= numberOfVertex; i++) {
            if (!set.contains(i)) {
                numberOfConnectedComponent++;
                DFSGraphImplHelper(adjList, i, result, set);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        GraphAdjacencyList g1 = GraphData.getDisconnectedGraph();
        GraphAdjacencyList g2 = GraphData.getGraph();
        System.out.println(g1.adjList);
        DFSDisconnectedGraphImpl(g1.adjList,  7);
        System.out.println(g2.adjList);
        DFSconnectedGraphImpl(g2.adjList, 0);
    }

}
