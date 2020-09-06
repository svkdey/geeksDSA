package GraphQuickRecap;

import java.util.ArrayList;

public class CycleDetetionInDirectedGraph {
    public static boolean solve(ArrayList<ArrayList<Integer>> graph, int src, int parent, boolean visited[]) {

        visited[src] = true;
        for (int child : graph.get(src)) {
            if (!visited[child]) {
                if (solve(graph, child, src, visited)) {
                    return true;
                }
            } else if (child != parent) {
                return true;
            }
        }
        return false;
    }
    static void cycleDetect(ArrayList<ArrayList<Integer>> graph,int n){
        boolean visisted[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visisted[i]){
                if(solve(graph,i,-1,visisted)){
                    System.out.println("Cycle found");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
