package GraphQuickRecap;



import java.util.ArrayList;

class Pair {
    int to;
    int weight;

    public Pair() {
    }

    public Pair(int vertex, int weight) {
        this.to = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "vertex=" + to +
                ", weight=" + weight +
                '}';
    }
}

public class GraphAdjcencyListDirectedWeightedGraph {
    public ArrayList<ArrayList<Pair>> adjList;

    public GraphAdjcencyListDirectedWeightedGraph(int vertexNumber) {
        this.adjList = new ArrayList<>(vertexNumber);
        for (int i = 0; i < vertexNumber; i++) {
            this.adjList.add(new ArrayList<Pair>());
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        this.adjList.get(v1).add(new Pair(v2, weight));
    }

    @Override
    public String toString() {
        return "GraphAdjcencyListDirectedWeightedGraph{" +
                "adjList=" + adjList +
                '}';
    }
}
