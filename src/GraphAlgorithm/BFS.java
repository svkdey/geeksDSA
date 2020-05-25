package GraphAlgorithm;

import Data.GraphData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/**
 Application of BFS
    shortest path in unweighted Graph
    crawler in search engine
    peer to peer networks
    Social networks search
    in garbage collection (Cheney's algorithm)
    cycle detetion
    ford Fulkerson algo
    Board casting
 **/


//o(v+e)

public class BFS {
    public static void BFSConnectedGraphimpl(ArrayList<ArrayList<Integer>> adjList, int v, int s) {
        //list of visited vertex
        HashSet<Integer> visited = new HashSet<>();
        //as a process of standard travesal
        Queue<Integer> q = new LinkedList<>();
        //source is added in queue
        q.add(s);
        //vertex which are in queue marked as visited
        visited.add(s);

        //result list
        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int vertex = q.remove();
            result.add(vertex);
            //get the adj. list of vertex
            ArrayList<Integer> vList = adjList.get(vertex);

            for (int i : vList) {
                //if already visited then it should not be visit again
                if (!visited.contains(i)) {
                    //vertex is in queue and marked visited
                    q.add(i);
                    visited.add(i);
                }
            }
        }

        System.out.println(result);
    }
    // Number of Connected Components gives number of discontinuity in graph .
    //island problem
    public static void BFSDisonnectedGraphimpl(ArrayList<ArrayList<Integer>> adjList, int v) {
        HashSet<Integer> visisted = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        //to count number of disconnected components in graph
        int numberOfConnectedComponent=0;
        for (int i = 0; i <= v; i++) {
            if (!visisted.contains(i)) {
                numberOfConnectedComponent++;

                BFSDisonnectedGraphimplTraverse(adjList, v, i, visisted, result);
            }
        }
        System.out.println("Number of Connected Components :"+numberOfConnectedComponent);
        System.out.println(result);
    }

    public static void BFSDisonnectedGraphimplTraverse(ArrayList<ArrayList<Integer>> adjList, int v, int s, HashSet<Integer> visited, ArrayList<Integer> result) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited.add(s);
        while (!q.isEmpty()) {
            Integer vertex = q.remove();
            result.add(vertex);
            ArrayList<Integer> list = adjList.get(vertex);
            for (Integer i : list) {
                if (!visited.contains(i)) {
                    q.add(i);
                    visited.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyList g1 = GraphData.getDisconnectedGraph();
        GraphAdjacencyList g2 = GraphData.getGraph();
        System.out.println(g1.adjList);
        BFSDisonnectedGraphimpl(g1.adjList,  7);
        System.out.println(g2.adjList);
        BFSDisonnectedGraphimpl(g2.adjList,  4);
    }
}
