package GraphQuickRecap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    static class Vertex {

        int v;
        int cost;

        public Vertex( int t, int c) {


            v = t;
            cost = c;
        }

        @Override
        public String toString() {
            return "Edge  to=" + v + ", cost=" + cost + "]";
        }

    }

    static class Pair {
        int vertex;
        int weight;

        public Pair(int v, int w) {
            // TODO Auto-generated constructor stub
            vertex = v;
            weight = w;
        }

        @Override
        public String toString() {
            return "Pair [vertex=" + vertex + ", weight=" + weight + "]";
        }

    }
    static class Graph {

        public ArrayList<ArrayList<Pair>> adjList;

        public Graph(int vertexNumber) {
            this.adjList = new ArrayList<ArrayList<Pair>>(vertexNumber);
            for (int i = 0; i < vertexNumber; i++) {
                this.adjList.add(new ArrayList<Pair>());
            }
        }

        public void addEdge(int v1, int v2, int weight) {
            this.adjList.get(v1).add(new Pair(v2, weight));
            this.adjList.get(v2).add(new Pair(v1, weight));
        }
    }

    public static void DijkstraAlgo(ArrayList<ArrayList<Pair>> graph,int startVertex,int n) {
        Comparator<Vertex> rule=(a,b)->{
            return a.cost-b.cost;
        };
        int distance[]=new int[n];
        boolean v[]=new boolean[n];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[startVertex]=0;
        PriorityQueue<Vertex> pq=new PriorityQueue<>(rule);
        pq.add(new Vertex(startVertex,0));
        while(!pq.isEmpty()){
            Vertex src=pq.remove();
            System.out.println(src.v);
            v[src.v]=true;

            for(Pair child:graph.get(src.v)){
               int vtx=child.vertex,vtx_wt=child.weight;
               if(!v[vtx]){
                   int srcToVtxDistance=vtx_wt+distance[src.v];

                   if(distance[vtx]>srcToVtxDistance){
                       distance[vtx]=srcToVtxDistance;
                       pq.add(new Vertex(vtx,srcToVtxDistance));
                   }
               }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
        DijkstraAlgo(graph.adjList,0, graph.adjList.size());
    }
}
