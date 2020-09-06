package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

import Data.GraphData;
/**
 applicable for only directed graph.
 it gives minimum distance for directed graph with -ve edges
 
 O(V*E) algorithm
 **/
public class BellManFordAlgorithm {
	public static void bellManFordAlgorithmImpl(ArrayList<ArrayList<Pair>> adjList,int src,int V ) {
		int dist[]=new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src]=0;
		//for each u vertex relax all its v nodes
		for(int c=0;c<V;c++) {
			ArrayList<Pair> _VList=adjList.get(c);
			for(Pair _v:_VList) {
				if(dist[c]!=Integer.MAX_VALUE&& dist[_v.vertex]>dist[c]+_v.weight) {
					dist[_v.vertex]=dist[c]+_v.weight;
				}
				
			}
		}
		for(int c=0;c<V;c++) {
			ArrayList<Pair> _VList=adjList.get(c);
			for(Pair _v:_VList) {
				if(dist[c]!=Integer.MAX_VALUE&& dist[_v.vertex]>dist[c]+_v.weight) {
					System.out.println("Graph contains -ve cycle");
					break;
				}
				
			}
		}
		System.out.println(Arrays.toString(dist));
		
	}
	public static void main(String[] args) {
		GraphAdjcencyListDirectedWeightedGraph graph=GraphData.getDirectWeightedGraphWithNegativeEdge();
		System.out.println(graph.adjList);
		bellManFordAlgorithmImpl(graph.adjList, 2, graph.adjList.size());
	}

}
