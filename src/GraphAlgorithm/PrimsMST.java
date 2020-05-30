package GraphAlgorithm;

import java.util.Arrays;

/**
 * spanning of tree (minimum weighted edges+all vertex+no loops)
 *  ie only applicable for connected undirected graph
 * 
 * @author Souvik
 *O(v*v)
 */



public class PrimsMST {
    public static void primMST(int adjList[][], int V) {
        //the vertex that will be in solution the minimum weight order
        int inMST[] = new int[V];
        //minimum weight corresponding to i_th vertex
        int key[] = new int[V];

        boolean mstSet[] = new boolean[V];
        //initially nothing has traverse

        //i_th vertex has infy value
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        //weight of 1st vertex is 0
        key[0] = 0;
        inMST[0] = -1; // 0 index node in mst

        for (int c = 0; c < V - 1; c++) {
//            get the key that is minimum value
//            which is connected to the vertex which we have taken in inMST
            int u = minKey(key, mstSet, V);
            //marked as visited
            mstSet[u] = true;

            //include it's weight and it's idx in inMST
            for (int i = 0; i < V; i++) {
                //most important line .it takes u vertex goes to possible edges.
                // finds if minimum value of edge that's considered and not visited,it updates that
                if (adjList[u][i] != 0 && mstSet[i] == false
                        && adjList[u][i] < key[i]) {
                    inMST[i] = u;
                    key[i] = adjList[u][i];
                }
            }
        }
        System.out.println(Arrays.toString(inMST));

        System.out.println(Arrays.toString(key));
//        System.out.println(Arrays.toString(inMST));
    }
//this funtion returns unvisted minimum key's Index
    
    public static int minKey(int key[], boolean mstSet[], int V) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                minIdx = v;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]
                {{0, 2, 0, 7},
                {2, 0, 3, 5},
                {0, 3, 0, 4},
                {7, 5, 4, 0}};

        // Print the solution
        primMST(graph, 4);
    }
}
