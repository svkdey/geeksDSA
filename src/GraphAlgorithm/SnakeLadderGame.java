package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderGame {
	static class GraphAdjacencyListDirectedGraph {
		public ArrayList<ArrayList<Integer>> adjList;

		public GraphAdjacencyListDirectedGraph(int vertexNumber) {
			this.adjList = new ArrayList<ArrayList<Integer>>(vertexNumber);
			for (int i = 0; i < vertexNumber; i++) {
				this.adjList.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int v1, int v2) {
			this.adjList.get(v1).add(v2);
		}

		public void printGraph(ArrayList<ArrayList<Integer>> adjList) {
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
			return "GraphAdjacencyListDirectedGraph{" + "adjList=" + adjList + '}';
		}
	}



	public static void solve(ArrayList<ArrayList<Integer>> adjList, int n,ArrayList<Integer> list) {
		Queue<Integer> q = new LinkedList<Integer>();
		int visited[] = new int[n+1];
		q.add(0);
		visited[0] = 1;
	
		while (!q.isEmpty()) {
			int vertex = q.remove();
			if (vertex == n) {
		
				return;
			}

			int vertexTobeTaken = vertex;
			int i = 0;
			System.out.println("at "+ vertexTobeTaken);
//			for moving 1 to 6 if we find ladder we will break else we will take max move of 6
			for (i = 1; i <= 6 && vertexTobeTaken <=n-1; i++) {
				ArrayList<Integer> _vlist = adjList.get(vertexTobeTaken);
				int lastVertex = vertexTobeTaken;
				for (int x : _vlist) {
					//at each step take max value
					vertexTobeTaken = Math.max(vertexTobeTaken, x);
				
				}
				//checking ladder is found or not
				if (vertexTobeTaken != lastVertex + 1) {
//					i++;
					break;
				}
			}
			//checking max max ie 6 is at face of snake. if it is then we will take prev value
			if(i-1==6 && check(adjList.get(vertexTobeTaken),vertexTobeTaken)) {
				i=i-1;
				vertexTobeTaken=vertexTobeTaken-1;
			}
			
			q.add(vertexTobeTaken);
			list.add(i-1);
			visited[vertexTobeTaken] = 1;

		}
//		System.out.println(list);
	}
	private static boolean check(ArrayList<Integer> l,int v) {
		for(int x:l) {
			if(x<v) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		GraphAdjacencyListDirectedGraph graph = new GraphAdjacencyListDirectedGraph(35);
		for (int i = 0; i < 35; i++) {
			graph.addEdge(i, i +1);
		}
//		ladders
		graph.addEdge(10, 25);
	//
		graph.addEdge(2, 21);
		graph.addEdge(4, 7);
		graph.addEdge(19, 28);

//		snakes
		graph.addEdge(27, 0);
		graph.addEdge(20, 8);
		graph.addEdge(18, 6);
		graph.addEdge(16, 3);

		ArrayList<Integer> list = new ArrayList<Integer>();
//		graph.printGraph(graph.adjList);
		solve(graph.adjList, 35,list);
		System.out.println(list);

	}

}
