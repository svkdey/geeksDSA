package GraphAlgorithm;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class XTotalShape {
    public static void countX(int m,int n){
        String [] graph={"XXO", "OOX" ,"OXO", "OOO", "XOX" ,"XOX", "OXO", "XXO", "XXX", "OOO"};
        int count=0;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(visited[i][j]==false&&graph[i].charAt(j)=='X'){
//                    System.out.println("DFS called at"+i +" "+j);

                    DFS(graph,i,j,m,n,visited);
//                    show(visited);
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);


    }


    public static void DFS(String [] graph,int i,int j,int m,int n,  boolean visited[][]){
        if(i<0||i>=m||j<0||j>=n||graph[i].charAt(j)=='O'||visited[i][j]==true){
            return;
        }
        System.out.println(i+" "+j);
        visited[i][j]=true;
       // if(graph[i].charAt(j)=='X'){
            DFS(graph,i,j+1,m,n,visited);
            DFS(graph,i,j-1,m,n,visited);
            DFS(graph,i+1,j,m,n,visited);
            DFS(graph,i-1,j,m,n,visited);
        //}
    }

    public static void main(String[] args) {
        countX(10,3);


    }
}
