package GraphQuickRecap;

import java.util.ArrayList;

public class NumberOfConnectedComponent {
    public static void NumberOfConnectedComponentByDFS(ArrayList<ArrayList<Integer>> graph,int n){
        boolean visited[]=new boolean[n];
        int numberOfDisconnectedComponent=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                numberOfDisconnectedComponent++;
                BasicDFSandBFS.dfs(graph,visited,i);
            }
        }
        System.out.println(numberOfDisconnectedComponent);
    }

    public static void NumberOfConnectedComponentByBFS(ArrayList<ArrayList<Integer>> graph,int n){
        boolean visited[]=new boolean[n];
        int numberOfDisconnectedComponent=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                numberOfDisconnectedComponent++;
                BasicDFSandBFS.bfs(graph,visited,i);
            }
        }
        System.out.println(numberOfDisconnectedComponent);
    }

}
