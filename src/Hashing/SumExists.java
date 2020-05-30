package Hashing;

import java.util.HashSet;

public class SumExists {
    public static int sumExists(int arr[], int sizeOfArray, int sum) {
        //Your code here, Geeks
        HashSet<Integer> s = new HashSet<Integer>();

        for (int i = 0; i < sizeOfArray; i++) {
            if (s.contains(arr[i])) {
                return 1;
            } else {
                s.add(sum - arr[i]);
            }
        }
        System.out.println(s);
        return 0;
    }

    public static int sumExists2(int arr[], int sizeOfArray, int sum) {
        HashSet<Integer> s = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < sizeOfArray; i++) {
            if (s.contains(arr[i])) {
                count++;
            } else {
                s.add(sum - arr[i]);
            }
        }
        System.out.println(count);
        System.out.println(s);
        if (count == 2) return 1;
        else return 0;

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(sumExists2(new int[]{9, 9, 7, 6, 5, 4}, 6, 18));
    }

}
