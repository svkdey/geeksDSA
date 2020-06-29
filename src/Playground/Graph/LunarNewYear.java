package Playground.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//https://codeforces.com/problemset/problem/1106/D
public class LunarNewYear {
	static class GraphAdjacencyList {
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
//	public static void dfs(ArrayList<ArrayList<Integer>> adjList,boolean v[],int src) {
//		if(v[src]) {
//			return;
//		}
//		System.out.print(src+" ");
//		v[src]=true;
//		ArrayList<Integer> child_v_list=adjList.get(src);
//		Collections.sort(child_v_list);
//		for(int child:child_v_list) {
//			if(!v[child]) {
//				dfs(adjList, v, src);
//			}
//		}
//	}


	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(sc.readLine());
//		while (t-- > 0) {
			String[] s = sc.readLine().split(" ");
			int v=Integer.parseInt(s[0]);
			int e=Integer.parseInt(s[1]);
			GraphAdjacencyList graph=new GraphAdjacencyList();
			graph.addVertex(v+1);
			for(int i=0;i<e;i++) {
				String[] s2 = sc.readLine().split(" ");
				graph.addEdge(Integer.parseInt(s2[0]),Integer.parseInt(s2[1]));
			}
			
			boolean visited[]=new boolean[v+1];
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			pq.add(1);
			visited[1]=true;
			while(!pq.isEmpty()) {
				int node=pq.remove();
				System.out.print(node+" ");
				
				for(int x:graph.adjList.get(node)) {
					if(!visited[x]) {
						pq.add(x);
						visited[x]=true;
					}
				}
			}

//		}
	}
}
