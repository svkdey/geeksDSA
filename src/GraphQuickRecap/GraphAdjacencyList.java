package GraphQuickRecap;


import java.util.ArrayList;


public class GraphAdjacencyList {
    public ArrayList<ArrayList<Integer>> adjList;
    public ArrayList<Integer> vertexList;

    public GraphAdjacencyList() {
        // TODO Auto-generated constructor stub

        adjList = new ArrayList<ArrayList<Integer>>();
    }

    public void addVertex(int numberOfVertex) {
        vertexList = new ArrayList<Integer>();

        for (int i = 0; i <= numberOfVertex; i++) {
            vertexList.add(i);
            ArrayList<Integer> a = new ArrayList<Integer>();
            adjList.add(a);
        }
    }

    public void addEdge(int v1, int v2) {
        if (adjList.size() > v1 && adjList.size() > v2) {
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        } else {
            throw new Error("Vertex does not exist");
        }

    }

    public ArrayList<Integer> getVertex() {
        return vertexList;
    }

    public void getEdgeList(int v1, int v2) {
        if (adjList.size() > v1 && adjList.size() > v2) {
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        } else {
            throw new Error("Vertex does not exist");
        }

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
        return "GraphAdjacencyList [adjList=" + adjList + "]";
    }



}
