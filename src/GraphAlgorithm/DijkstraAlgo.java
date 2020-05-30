package GraphAlgorithm;


import Data.GraphData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * applicable for weight graphs.
 * for a vertex u we relax u's adjacent vertex by relax operation ie
 * <p>
 * relax(u,v) ie
 * {
 * if(d[v]>d[u]+w(u,v)){
 * d[v]=d[u]+w(u,v)
 * }
 * }
 * Notes:Does not work if graph has -ve edges
 * mcq:if we add certain weight in any edges dijksra wont work
 **/
//O((E+V)*LogV)


public class DijkstraAlgo {
//    static class Pair {
//        int vertex;
//        int weight;
//
//        public Pair(int vertex, int weight) {
//            this.vertex = vertex;
//            this.weight = weight;
//        }
//    }
	//BFS =>queue replaces priority queue
	
    public static void dijkstraAlgoImpl(ArrayList<ArrayList<Pair>> graph, int src, int V) {
    	//to keep distance in measure
        int dist[] = new int[V];
    	//to keep vertex which are visited
        boolean[] visited = new boolean[V];
        
        //arrays fill with infinity
        Arrays.fill(dist,Integer.MAX_VALUE);
        //minheap
        Comparator<Pair> c = (o1, o2) -> o1.weight - o2.weight;
        PriorityQueue<Pair> pq = new PriorityQueue<>(c);
        
        //distance at index src is 0 rest infy
        dist[src] = 0;
        Pair p = new Pair(src,dist[src]);
        pq.add(p);

        while (!pq.isEmpty()) {
//        	BFS
            Pair extractedVertex = pq.poll();
            int _v = extractedVertex.vertex;
            //instead of making node visited during adding ,we making it visited during removing
            if (!visited[_v]) {
                visited[_v] = true;

                ArrayList<Pair> _vlist = graph.get(_v);
                for (Pair v : _vlist) {
                    int presentVertex = v.vertex;
                    if (!visited[presentVertex]) {
                    	
                        int newWeight = dist[_v] + v.weight;
                        int currentWeight = dist[presentVertex];
                       
                        //relaxing and updating in pq
                        if (currentWeight > newWeight) {
                            Pair updatedVertex = new Pair(presentVertex, newWeight);
                            pq.offer(updatedVertex);
                            dist[presentVertex] = newWeight;

                        }

                    }
                }
            }
        }
//        System.out.println(Arrays.toString(visited));
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        GraphAdjacencyListWeightedUndirectedGraph graph= GraphData.getDirectWeightedGraph();
        System.out.println(graph.adjList);

        dijkstraAlgoImpl(graph.adjList,1,graph.adjList.size());

    }
}
