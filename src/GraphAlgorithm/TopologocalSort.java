package GraphAlgorithm;

import Data.GraphData;

import java.lang.reflect.Array;
import java.util.*;

/**
 * the topological sort on directed graph say .1st parent will be visited .then
 * their any of child will be doing the visited/
 *
 * //this cant be done on cyclic graph
 **/
public class TopologocalSort {
	public static int calInegree(int vertex, ArrayList<ArrayList<Integer>> adjList) {
		int count = 0;
		for (ArrayList<Integer> v : adjList) {
			if (v.contains(vertex)) {
				count++;
			}
		}
		return count;
	}

	public static void TopologocalSortImplyByKahnBFS(ArrayList<ArrayList<Integer>> adjList, int numberofVertex) {
		// store indegree of every vertex
		// find In degree of each Vertex vertex
		int InDegreeVertex[] = new int[numberofVertex];// o(V)

		for (int i = 0; i < numberofVertex; i++) { // o(V*E)
			InDegreeVertex[i] = calInegree(i, adjList);
		}
		// o(E+V)
		// System.out.println(zeroInDegreeVertex);
		// create Queue
		// create visited Hashset visited

		// System.out.println(Arrays.toString(InDegreeVertex));
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();

		// add all zero indegree vertex in queue
		for (int i = 0; i < InDegreeVertex.length; i++) {
			if (InDegreeVertex[i] == 0) {
				q.add(i);
				visited.add(i);
			}
		}

		// do the BFS
		while (!q.isEmpty()) {
			int vertex = q.remove();
			System.out.print(vertex + " ");
			for (Integer v : adjList.get(vertex)) {
				// deduct -1 all the iin all other vertex
				InDegreeVertex[v] = InDegreeVertex[v] - 1;
				if (!visited.contains(v) && InDegreeVertex[v] == 0) {
					q.add(v);
					visited.add(v);
				}
			}
		}
	}

	// a vertex can be push inside stack if all its dependent are in pushed into
	// stack
	public static Stack<Integer> tropoLogicalSortByDFS(ArrayList<ArrayList<Integer>> adjList, int numberofVertex) {
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < numberofVertex; i++) {
			if (!visited.contains(i)) {
				DFSforTopologicalSort(i, stack, adjList, visited);
			}
		}
//        while(!stack.isEmpty()){
//            System.out.print(stack.pop()+" ");
//        }
		System.out.println(stack);
		return stack;
	}

	public static void DFSforTopologicalSort(int v, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adjList,
			HashSet<Integer> visited) {
		visited.add(v);
		ArrayList<Integer> aVertexList = adjList.get(v);
		// going to child vertexs
		for (Integer vertex : aVertexList) {
			if (!visited.contains(vertex)) {
				DFSforTopologicalSort(vertex, stack, adjList, visited);
			}
		}
		// adding v after traversing all child
		stack.push(v);
//        return stack;
	}

	public static void main(String[] args) {
//        GraphAdjacencyListDirectedGraph graph = GraphData.getCyclicDirectedGraphWithMultipleZeroIndegree();
//        System.out.println(graph);
		GraphAdjacencyListDirectedGraph g = new GraphAdjacencyListDirectedGraph(4);
		int couses[][] = { { 1, 0 }, { 0, 2 }, { 2, 3 } };
		int n = 4;
		for (int x[] : couses) {
			g.addEdge(x[0], x[1]);
		}
		System.out.println(g.adjList);
		tropoLogicalSortByDFS(g.adjList, 4);
//        System.out.println();
//        TopologocalSortImplyByKahnBFS(graph.adjList, graph.adjList.size());

	}
}
