package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class PairSumIfExists {
    public static void pairSumInArray(int arr[], int target) {
        // TODO Auto-generated method stub
        HashSet<Integer> hs = new HashSet<>();

        for (int i : arr) {
            int temp = target - i;
            if (hs.contains(temp)) {
                System.out.println(temp + " " + i);
                break;
            } else {
                hs.add(i);
            }
        }


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int n = 16;

        pairSumInArray(A,n);
    }

}
