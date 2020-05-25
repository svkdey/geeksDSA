package GraphAlgorithm;

import Data.GraphData;

import java.util.*;


// o(V+E)
public class CycleDetectionInaGraph {
    /**
     * will return flase if no cycle,
     * true if cycle
     *  **/
    public static boolean ifCycleInUndirectedGraph(ArrayList<ArrayList<Integer>> adjList, int numberOfVertex) {
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited.contains(i)) {
                if (ifCycleDFS(adjList, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ifCycleDFS(ArrayList<ArrayList<Integer>> adjList, int source, HashSet<Integer> visited, int parent) {
        visited.add(source);
        ArrayList<Integer> list = adjList.get(source);
        //same dfs pattern
        //only keep remember who was the parent .if parent ==adjacent vertex. then its not a cycle
        for (int v : list) {
            if (!visited.contains(v)) {
                if(ifCycleDFS(adjList, v, visited, source)){
                    return true;
                }
            } else if (parent != v) {
                return true;
            }
        }
        return false;
    }
    /**
     will return flase if no cycle,
     true if cycle
     ***/
    //idea is that during recursive stack call if there is a back stack call then there is a cycle
    public static boolean ifCycleInDirectedGraph(ArrayList<ArrayList<Integer>> adjList, int numberOfVertex) {
        HashSet<Integer> visited = new HashSet<>();
        boolean recStack[]=new boolean[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited.contains(i)) {
                if (ifCycleDFSwithDirectedGraph(adjList, i, visited,recStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean ifCycleDFSwithDirectedGraph(ArrayList<ArrayList<Integer>> adjList, int source, HashSet<Integer> visited, boolean recSt[]) {
            visited.add(source);
            recSt[source]=true;
            ArrayList<Integer> list=adjList.get(source);

            for(Integer v:list){
                if(!visited.contains(v)&&ifCycleDFSwithDirectedGraph(adjList,v,visited,recSt)){
                    return true;
                }else if(recSt[v]==true){
                    return true;
                }
            }
            recSt[source]=false;
            return false;
    }
    //method 2
    public static int calculateIndegree(ArrayList<ArrayList<Integer>> adjList,int v){
        int count=0;
        for(ArrayList<Integer> vertexList:adjList){
            for(Integer vertex:vertexList){
                if(vertex==v){
                    count++;
                }
            }
        }
       return count;
    }
/**
 will return true if no cycle,
 false if cycle
 **/

//BFS approach
    public static boolean ifCycleInDirectedGraphByKhanAlgo(ArrayList<ArrayList<Integer>> adjList, int numberOfVertex) {
        int indegree[]=new int[numberOfVertex];
        for (int i=0;i<numberOfVertex;i++){
            indegree[i]=calculateIndegree(adjList,i);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numberOfVertex;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int vertex = q.remove();


            for (Integer v : adjList.get(vertex)) {
                //deduct -1 all the iin all other vertex
                indegree[v]= indegree[v]-1;
                if (indegree[v]==0) {
                    q.add(v);
                }
            }

            count++;
        }
        System.out.println(Arrays.toString(indegree));
        if(count==numberOfVertex){
            return true;
        }else{
            return false;
        }

    }
    public static void main(String[] args) {
//        GraphAdjacencyList g2 = GraphData.getNoCycleGraph();
//        System.out.println(g2.adjList);
//        System.out.println(ifCycleInUndirectedGraph(g2.adjList,  g2.vertexList.size()));
//        GraphAdjacencyListDirectedGraph gDirected=GraphData.getCyclicDirectedGraph();
//        System.out.println(gDirected);
        GraphAdjacencyListDirectedGraph graph=GraphData.getCyclicDirectedGraph();
        System.out.println(graph);
        System.out.println(ifCycleInDirectedGraph(graph.adjList,graph.adjList.size()));


    }
}
