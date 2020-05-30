package GraphAlgorithm;

import java.util.*;
import java.lang.*;
import java.io.*;
class CheckPathExists{
    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner (System.in);
        int T = in.nextInt();
        while(T-->0){
            int N = in.nextInt();
            // String[] M = in.nextLine().split(" ");

            int A[][] = new int[N][N];
            int k=0;
            int a=0,b=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    int ip=in.nextInt();
                    if(ip==1){
                        a=i;b=j;
                    }
                    A[i][j]=ip;
                    k++;
                }
            }
            //for(int i=0;i<N;i++){
            //      for(int j=0;j<N;j++){

            //         System.out.print(A[i][j]+" ");

            //     }
            //      System.out.println();
            // }
            // sb.append();
            System.out.println(solve(A,N,a,b));
        }

    }
    static boolean visited[][]=null;
    public static int solve (int[][] graph,int size,int i,int j) {
        visited = new boolean[size][size];
        if(DFS(graph,size,i,j)){
            visited=null;
            return 1;
        }else{
            visited=null;
            return 0;
        }

    }
    public static boolean DFS (int[][] graph,int size,int i,int j) {
        if(i<0||i>=size||j<0||j>=size||graph[i][j]==0||visited[i][j]==true){
            return false;
        }
        visited[i][j]=true;
        if(graph[i][j]==2){
            return true;
        }
        if(DFS(graph,size,i+1,j)){
            return true;
        }
        if(DFS(graph,size,i-1,j)){
            return true;
        }
        if(DFS(graph,size,i,j+1)){
            return true;
        }
        if(DFS(graph,size,i,j-1)){
            return true;
        }
        return false;
    }
}