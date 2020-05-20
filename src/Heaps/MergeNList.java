package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeNList {
    public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = arrays.length;
        for (int i = 0; i < n; i++) {
            int m = arrays[i].length;
            for (int j = 0; j < m; j++) {
                pq.add(arrays[i][j]);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(mergeKArrays(arr,3));
    }

}
