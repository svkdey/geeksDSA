package Sorting;

import java.util.ArrayList;

public class ThreeWayPartitionInRange {
    public void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public ArrayList<Integer> threeWayPartition(ArrayList<Integer> a, int c,
                                                int b) {
        //add code here.
        int i = 0;
        int mid = 0;
        int l = a.size() - 1;
        while (l >= mid) {
            if (a.get(mid) < c) {
                swap(a, i, mid);
                i++;
                mid++;

            } else if (a.get(mid) >= c && a.get(mid) <= b) {
                mid++;
            } else if (a.get(mid) > b) {
                swap(a, l, mid);
                l--;
            }
        }

        return a;

    }

}
