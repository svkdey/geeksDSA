package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;

import Playground.Graph.DijkstraAlgorithm.Destination;

public class BellManFordAlgo {
	// step1 : dis[src]=0 else all infy
	// step 2: for 0 to n-1 vertex relax .each each edge.
	// step 3: if i can relax more. then it contains -ve edge cycle.
	static class Edge { 
        int src, dest, weight; 
        Edge() 
        { 
            src = dest = weight = 0; 
        } 
    }; 
  
    
  
    // Creates a graph with V vertices and E edges
    static class Graph{
    	int V, E; 
        Edge edge[]; 
    public Graph(int v, int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[e]; 
        for (int i = 0; i < e; ++i) 
            edge[i] = new Edge(); 
    } 
    }
    // The main function that finds shortest distances from src 
    // to all other vertices using Bellman-Ford algorithm. The 
    // function also detects negative weight cycle 
    static void BellmanFord(Graph graph, int src) 
    { 
        int V = graph.V, E = graph.E; 
        int dist[] = new int[V]; 
  
        // Step 1: Initialize distances from src to all other 
        // vertices as INFINITE 
        for (int i = 0; i < V; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        dist[src] = 0; 
  
        // Step 2: Relax all edges |V| - 1 times. A simple 
        // shortest path from src to any other vertex can 
        // have at-most |V| - 1 edges 
        for (int i = 1; i < V; ++i) { 
            for (int j = 0; j < E; ++j) { 
                int u = graph.edge[j].src; 
                int v = graph.edge[j].dest; 
                int weight = graph.edge[j].weight; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
                    dist[v] = dist[u] + weight; 
            } 
        } 
  
        // Step 3: check for negative-weight cycles. The above 
        // step guarantees shortest distances if graph doesn't 
        // contain negative weight cycle. If we get a shorter 
        // path, then there is a cycle. 
        for (int j = 0; j < E; ++j) { 
            int u = graph.edge[j].src; 
            int v = graph.edge[j].dest; 
            int weight = graph.edge[j].weight; 
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
                System.out.println("Graph contains negative weight cycle"); 
                return; 
            } 
        } 
        System.out.println(Arrays.toString(dist));
        printArr(dist, V); 
    } 
  
    // A utility function used to print the solution 
   static void printArr(int dist[], int V) 
    { 
        System.out.println("Vertex Distance from Source"); 
        for (int i = 0; i < V; ++i) 
            System.out.println(i + "\t\t" + dist[i]); 
    } 
  
    // Driver method to test above function 
    public static void main(String[] args) 
    { 
        int V = 5; // Number of vertices in graph 
        int E = 5; // Number of edges in graph 
  
        Graph graph = new Graph(V, E); 
  
        // add edge 0-1 (or A-B in above figure) 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = 20; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = 3; 
        graph.edge[1].dest = 4; 
        graph.edge[1].weight = 50; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src = 2; 
        graph.edge[2].dest = 1; 
        graph.edge[2].weight = 13; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = -33; 
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = 2; 
        graph.edge[4].dest = 3; 
        graph.edge[4].weight = 55; 
  
       
        BellmanFord(graph, 0); 
    } 

}
