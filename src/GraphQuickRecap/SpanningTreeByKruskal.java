package GraphQuickRecap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SpanningTreeByKruskal {
    static class DisJointSet{
        int arr[]=null;

        public DisJointSet(int n) {
            this.arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=i;
            }
        }
        public void union(int x,int y){
            int x_root=find(x);
            int y_root=find(y);
            if(x_root!=y_root){
                arr[x_root]=y_root;
            }
        }
        public int find(int x){
            if(arr[x]==x){
                return x;
            }
            else return arr[x]=find(arr[x]);
        }
        public boolean isConnected(int x,int y){
            return find(x)==find(y);
        }
    }


    public static int spanningTreeByKruskalImpl(List<GraphData.Edge> graph,int n) {
        Comparator<GraphData.Edge> rule=(a,b)->{
            return a.weight-b.weight;
        };
        PriorityQueue<GraphData.Edge> pq=new PriorityQueue<>(rule);
        for(GraphData.Edge e:graph) pq.add(e);
        DisJointSet dsu=new DisJointSet(n);
        int ans=0;


        while(!pq.isEmpty()){
            GraphData.Edge e=pq.remove();
            if(!dsu.isConnected(e.x,e.y)){
                dsu.union(e.x,e.y);
                System.out.println(e);
                ans+=e.weight;
            }
        }
        System.out.println(ans);
        printDisconnectedComponents(dsu.arr,n);
        return ans;
    }
    public static void printDisconnectedComponents(int arr[],int n){
        for(int i=0;i<n;i++){
            if(arr[i]==i){
                System.out.println("disconnected component : "+i);
            }
        }
    }



}
