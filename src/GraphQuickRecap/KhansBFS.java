package GraphQuickRecap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KhansBFS {
    public static void solve(ArrayList<ArrayList<Integer>> graph, int n) {
        //count inDegree
        int inDedree[]=new int[n];

        for(int i=0;i<n;i++){
            for(ArrayList<Integer> l:graph){
                if(l.contains(i)){
                    inDedree[i]++;
                }
            }
        }

        //take all in degree =0;
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(inDedree[i]==0){
                q.add(i);
                visited[i]=true;
            }
        }
        //now do the BFS
        while(!q.isEmpty()){
            int v=q.remove();
            System.out.println(v+"-->");
            for(int ancestor:graph.get(v)){
                inDedree[ancestor]--;
                if(!visited[ancestor]&&inDedree[ancestor]==0){
                    q.add(ancestor);
                    visited[ancestor]=true;
                }
            }
        }

    }
}
