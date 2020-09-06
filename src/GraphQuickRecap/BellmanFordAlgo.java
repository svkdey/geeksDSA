package GraphQuickRecap;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgo {
    static class Pair{
        int to,weight;

        public Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void bellManFordAlgorithmImpl(ArrayList<ArrayList<GraphQuickRecap.Pair>> adjList, int src, int V ) {
        int distance[]=new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;

        for(int i=0;i<V;i++){
            ArrayList<GraphQuickRecap.Pair> nbr=adjList.get(i);
            for(GraphQuickRecap.Pair e:nbr){
                if(distance[i]!=Integer.MAX_VALUE&&distance[e.to]>e.weight+distance[i]){
                    distance[e.to]=e.weight+distance[i];
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        //if we can further relax any vertex ,then definitely -ve cycle exists
        for(int i=0;i<V;i++){
            ArrayList<GraphQuickRecap.Pair> nbr=adjList.get(i);
            for(GraphQuickRecap.Pair e:nbr){
                if(distance[i]!=Integer.MAX_VALUE&&distance[e.to]>e.weight+distance[i]){
                    System.out.println("-ve cycle");
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        bellManFordAlgorithmImpl(GraphData.getDirectWeightedGraphWithNegativeEdge().adjList,0,GraphData.getDirectWeightedGraphWithNegativeEdge().adjList.size());
    }
}
