package GraphQuickRecap;



import java.util.ArrayList;

public class GraphAdjacencyListDirectedGraph {
    public ArrayList<ArrayList<Integer>> adjList;

    public GraphAdjacencyListDirectedGraph(int vertexNumber) {
        this.adjList = new ArrayList<ArrayList<Integer>>(vertexNumber);
        for(int i=0;i<vertexNumber;i++){
            this.adjList.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int v1, int v2){
        this.adjList.get(v1).add(v2);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
        for (ArrayList<Integer> vertexlist : adjList) {
            System.out.print("vertex " + adjList.indexOf(vertexlist) + "==>");
            for (int vertex : vertexlist) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "GraphAdjacencyListDirectedGraph{" +
                "adjList=" + adjList +
                '}';
    }
}
