package GraphQuickRecap;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void solve(ArrayList<ArrayList<Integer>> graph, int src, boolean visited[], Stack<Integer> result){
        visited[src]=true;
        for(int child:graph.get(src)){
            if(!visited[child]){
                solve(graph, child, visited, result);
            }
        }
        result.add(src);
    }
    public static void topologicalSort(ArrayList<ArrayList<Integer>> graph,int n){
        boolean visisted[]=new boolean[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(!visisted[i]){
               solve(graph,i,visisted,stack);
            }
        }
        System.out.println(stack);
    }
}
