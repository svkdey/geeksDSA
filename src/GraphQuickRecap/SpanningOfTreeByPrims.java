package GraphQuickRecap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SpanningOfTreeByPrims {
    static class Edge {
        int src;
        int to;
        int cost;

        public Edge(int src, int t, int c) {
            this.src = src;

            to = t;
            cost = c;
        }

        @Override
        public String toString() {
            return "Edge [src=" + src + ", to=" + to + ", cost=" + cost + "]";
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

    public static int spanningOfTreeByPrims(ArrayList<ArrayList<Pair>> graph, int n,int src) {
        Comparator<GraphData.Edge> rule=(a, b)->{
            return a.weight-b.weight;
        };
        PriorityQueue<GraphData.Edge> pq=new PriorityQueue<>(rule);
        for(Pair p:graph.get(src)) {pq.add(new GraphData.Edge(src,p.vertex,p.weight));}

        boolean visited[]=new boolean[n];
        visited[src]=true;
        int ans=0;
        while(!pq.isEmpty()){
            GraphData.Edge edge=pq.remove();
            int v=edge.y;
            int wt=edge.weight;

            if(!visited[v]){
                for(Pair p:graph.get(v)){
                    pq.add(new GraphData.Edge(v,p.vertex,p.weight));
                }
                ans+=wt;
                System.out.println(edge);
                visited[v]=true;
            }

        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph graph = new Graph(4);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 5);
        graph.addEdge(2, 3, 4);
        graph.addEdge(1, 3, 15);
        spanningOfTreeByPrims(graph.adjList, 4, 0);
    }
}
