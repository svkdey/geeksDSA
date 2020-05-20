package Data;

import GraphAlgorithm.GraphAdjacencyList;

public class GraphData {
	public static GraphAdjacencyList getGraph() {
		GraphAdjacencyList graph=new GraphAdjacencyList();
		graph.addVertex(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(3, 1);
//		graph.addEdge(4, 1);

		return graph;
	}

}
