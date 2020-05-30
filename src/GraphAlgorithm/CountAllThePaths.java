package GraphAlgorithm;

import Data.GraphData;

import java.util.ArrayList;

public class CountAllThePaths {
    static int countOfpath=0;
    public static void countAllThePathsUtils(ArrayList<ArrayList<Integer>> adjList,int s,int d){

        System.out.println(dfs(adjList,s,d));
        countOfpath=0;
    }

//   we will go thorough all possible paths recursively.and when we reach s==d we will do count++;
    public static int dfs(ArrayList<ArrayList<Integer>> adjList,int s,int d){
      if(s==d){
          countOfpath++;
      }
      ArrayList<Integer> l=adjList.get(s);
      for(int _v:l){
          dfs(adjList,_v,d);
      }
      return countOfpath;
    }

    public static void main(String[] args) {
        GraphAdjacencyListDirectedGraph graph= GraphData.getNoCycleDirectedGraph();
        System.out.println(graph);
        countAllThePathsUtils(graph.adjList,0,3);
    }
}
