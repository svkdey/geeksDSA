package GraphQuickRecap;

import java.util.ArrayList;

public class CycleDetectionInUndirectGraph {
    public static boolean solve(ArrayList<ArrayList<Integer>> graph, int src,  boolean visited[],boolean inStack[]) {

        visited[src] = true;
        inStack[src]=true;
        for (int child : graph.get(src)) {
            if (!visited[child]) {
                if (solve(graph, child, visited,inStack)) {
                    return true;
                }
            } else if (inStack[child]) {
                return true;
            }
        }
        inStack[src]=false;
        return false;
    }
    static void cycleDetect(ArrayList<ArrayList<Integer>> graph,int n){
        boolean visisted[]=new boolean[n];
        boolean instack[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visisted[i]){
                if(solve(graph,i,visisted,instack)){
                    System.out.println("Cycle found");
                    break;
                }
            }
        }
    }
}
