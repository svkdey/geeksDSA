package GraphQuickRecap;

import java.util.ArrayList;
import java.util.List;

public class GraphData {
    static class Edge{
        int x,y;int weight;

        public Edge(int x, int t, int weight) {
            this.x = x;
            this.y = t;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    ", weight=" + weight +
                    '}';
        }
    }
    public static List<Edge> generateEdgeGraph(){
        List<Edge> graph=new ArrayList<>();

        graph.add(new Edge(0, 2, 6));
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 3, 5));
        graph.add(new Edge(2, 3, 4));
        graph.add(new Edge(1, 3, 15));
    return graph;


    }
    public static GraphAdjacencyList getGraph() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(3, 0);
        graph.addEdge(3, 2);
//		graph.addEdge(4, 2);

        return graph;
    }
    public static GraphAdjacencyList getGraphForColor() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);


        return graph;
    }


    public static GraphAdjacencyList getDisconnectedGraph() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        graph.addEdge(7, 5);

        return graph;
    }

    public static GraphAdjacencyList getNoCycleGraph() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 1);
        return graph;
    }

    public static GraphAdjacencyListDirectedGraph getNoCycleDirectedGraph() {
        GraphAdjacencyListDirectedGraph graph = new GraphAdjacencyListDirectedGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        return graph;
    }

    public static GraphAdjacencyListDirectedGraph getCyclicDirectedGraph() {
        GraphAdjacencyListDirectedGraph graph = new GraphAdjacencyListDirectedGraph(4);

        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        return graph;
    }

    public static GraphAdjacencyListDirectedGraph getCyclicDirectedGraphWithMultipleZeroIndegree() {
        GraphAdjacencyListDirectedGraph graph = new GraphAdjacencyListDirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(4, 3);
        return graph;
    }

    public static GraphAdjcencyListDirectedWeightedGraph getAcyclicDirectWeightedGraph() {
        GraphAdjcencyListDirectedWeightedGraph graph = new GraphAdjcencyListDirectedWeightedGraph(5);

        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 4, 50);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 33);
        graph.addEdge(2, 3, 55);
        return graph;
    }

    public static GraphAdjacencyListWeightedUndirectedGraph getDirectWeightedGraph() {
        GraphAdjacencyListWeightedUndirectedGraph graph = new GraphAdjacencyListWeightedUndirectedGraph(5);

        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 4, 50);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 33);
        graph.addEdge(2, 3, 55);
        return graph;
    }

    public static GraphAdjcencyListDirectedWeightedGraph getDirectWeightedGraphWithNegativeEdge() {
        GraphAdjcencyListDirectedWeightedGraph graph = new GraphAdjcencyListDirectedWeightedGraph(5);
        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 4, 50);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, -33);
        graph.addEdge(2, 3, 55);
        return graph;

    }

    public static GraphAdjacencyListDirectedGraph getNoCycleDirectedGraph2() {
        GraphAdjacencyListDirectedGraph g = new GraphAdjacencyListDirectedGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
//		g.addEdge(4, 0);
        return g;
    }
}
