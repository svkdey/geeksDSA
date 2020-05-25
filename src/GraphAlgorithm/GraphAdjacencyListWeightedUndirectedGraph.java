package GraphAlgorithm;

import java.util.ArrayList;

public class GraphAdjacencyListWeightedUndirectedGraph {
    public ArrayList<ArrayList<Pair>> adjList;

    public GraphAdjacencyListWeightedUndirectedGraph(int vertexNumber) {
        this.adjList = new ArrayList<ArrayList<Pair>>(vertexNumber);
        for(int i=0;i<vertexNumber;i++){
            this.adjList.add(new ArrayList<Pair>());
        }
    }
    public void addEdge(int v1, int v2,int weight){
        this.adjList.get(v1).add(new Pair(v2,weight));
        this.adjList.get(v2).add(new Pair(v1,weight));
    }
}
