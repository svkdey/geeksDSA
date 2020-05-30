package GraphAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;

public class IslandProblem {
    static int findIslands(ArrayList<ArrayList<Integer>> list, int n, int m) {
        HashSet<String> visited=new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++){
            ArrayList<Integer> _v=list.get(i);
            for(int j=0;j<m;j++) {

                String s = Integer.toString(i) + Integer.toString(j);
                if (!visited.contains(s)&& _v.get(j)==1) {

                    DFS(list, i, j, n, m,visited);
                    count++;
                }

            }
        }
        //  System.out.println(visited);
        return count;

    }
    public static void DFS(ArrayList<ArrayList<Integer>> graph,int i,int j,int n,int m,HashSet<String> visited){
        String s = Integer.toString(i) + Integer.toString(j);
        if(i<0 || i>=graph.size() || j<0 || j>=graph.get(i).size() || graph.get(i).get(j)==0||visited.contains(s)){
            return;
        }
        visited.add(s);
        DFS(graph,i+1,j,n,m,visited);
        DFS(graph,i-1,j,n,m,visited);
        DFS(graph,i,j+1,n,m,visited);
        DFS(graph,i,j-1,n,m,visited);
        DFS(graph,i+1,j+1,n,m,visited);
        DFS(graph,i-1,j-1,n,m,visited);
        DFS(graph,i-1,j+1,n,m,visited);
        DFS(graph,i+1,j-1,n,m,visited);

    }
    public static void main(String[] args) {

    }
}
