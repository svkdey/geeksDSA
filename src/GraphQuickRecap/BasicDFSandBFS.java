package GraphQuickRecap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BasicDFSandBFS {
    public static void dfs(ArrayList<ArrayList<Integer>> graph,boolean visited[],int src){
        visited[src]=true;
        System.out.println(src);
        for(int child:graph.get(src)){
            if(!visited[child]){
                dfs(graph,visited,src);
            }
        }


    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph,boolean visited[],int src){
        Queue<Integer> q=new LinkedList<>();

        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int node=q.remove();
            System.out.println(node);
            for(int child:graph.get(node)){
                if(!visited[child]){
                   q.add(child);
                   visited[child]=true;
                }
            }
        }
    }

}
