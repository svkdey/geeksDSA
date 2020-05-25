package GraphAlgorithm;

import Data.GraphData;


import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
    public static void shortestPathInDirectedAcyclicGraphImpl(ArrayList<ArrayList<Pair>> adjList, int source, int numberOfVertex) {
        //set all distance +ve infy except source
        int distance[] = new int[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            if (i != source) {
                distance[i] = 99999;
            }
        }
//        System.out.println(Arrays.toString(distance));
//        get tropological sort sequence
        ArrayList<Integer> result=new ArrayList<>();
        Stack<Integer> stack = tropoLogicalSortByDFS(adjList, numberOfVertex);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            result.add(v);


        }

//        for every i in troplogicl sort .we need to find adjacent list
        // for all the element in that list ie for all aadjacent element i
//        ..compute
/**             if( distance[_v.vertex] >distance[i] + _v.weight){
                distance[_v.vertex]=distance[i] + _v.weight;
 **/
       for(int i :result){

        ArrayList<Pair> list = adjList.get(i);

        for (Pair _v : list) {
            if( distance[_v.vertex] >distance[i] + _v.weight){
                distance[_v.vertex]=distance[i] + _v.weight;
            }

        }
       }
        System.out.println(Arrays.toString(distance));
    }

    public static Stack<Integer> tropoLogicalSortByDFS(ArrayList<ArrayList<Pair>> adjList, int numberofVertex) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numberofVertex; i++) {
            if (!visited.contains(i)) {
                DFSforTopologicalSort(i, stack, adjList, visited);
            }
        }

        return stack;
    }

    public static void DFSforTopologicalSort(int v, Stack<Integer> stack, ArrayList<ArrayList<Pair>> adjList, HashSet<Integer> visited) {
        visited.add(v);
        ArrayList<Pair> aVertexList = adjList.get(v);
        //going to child vertexs
//       System.out.println(aVertexList);
        for (Pair _v : aVertexList) {
            if (!visited.contains(_v.vertex)) {
                DFSforTopologicalSort(_v.vertex, stack, adjList, visited);
            }
        }
        //adding v after traversing all child
        stack.push(v);

    }

    public static void main(String[] args) {
        GraphAdjcencyListDirectedWeightedGraph graph = GraphData.getAcyclicDirectWeightedGraph();
        System.out.println(graph.adjList);
        shortestPathInDirectedAcyclicGraphImpl(graph.adjList, 1, graph.adjList.size());
    }
}
