package GraphQuickRecap;

import java.util.ArrayList;
import java.util.Arrays;

public class Bipartal {
    public static void solve(ArrayList<ArrayList<Integer>> graph, int n) {
        isGraphBilpartile=true;
        System.out.println(graph);
        int colors[]=new int[n];
        dfs(graph,0,1,colors,-1);
        System.out.println(Arrays.toString(colors));
        System.out.println(isGraphBilpartile);
    }
    static boolean isGraphBilpartile=true;
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src,int color,int colors[],int parent){

        colors[src]=color;
        for(int child:graph.get(src)){
            if(colors[child]==0){
                dfs(graph,child,3-color,colors,src);
            }else if(parent!=child && color==colors[child]){
                isGraphBilpartile=false;
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = new GraphAdjacencyList();
		graph.addVertex(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        solve(graph.adjList,graph.adjList.size());
    }
}
