package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Find number of pairs (x, y) in an array such that x^y > y^x
Given two arrays X[] and Y[] of positive integers, find number of pairs such that x^y > y^x where x is an element from X[] and y is an element from Y[].
Examples:

Input: X[] = {2, 1, 6}, Y = {1, 5}
Output: 3
Explanation: There are total 3 pairs where pow(x, y) is greater
than pow(y, x) Pairs are (2, 1), (2, 5) and (6, 1)



Input: X[] = {10, 19, 18}, Y[] = {11, 15, 9}
Output: 2
Explanation: There are total 2 pairs where pow(x, y) is greater
than pow(y, x) Pairs are (10, 11) and (10, 15)

*/
public class FindPairXY {
//    O(n^2)
    public static int countPairsNaive(int X[], int Y[], int m, int n)
    {
        // To store counts of 0, 1, 2, 3 and 4 in array Y
        int count=0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(Math.pow(X[i],Y[j])>Math.pow(Y[j],X[i])){
                    count++;
                }
            }
        }
        return count;

    }
    //o(mlg m+ n ln n);
    public static int countPairs(int X[], int Y[], int m, int n)
    {
        // To store counts of 0, 1, 2, 3 and 4 in array Y
       int[] NoOfY=new int[5];

       for(int i=0;i<n;i++){
           if(Y[i]<5){
               NoOfY[Y[i]]++;
           }
       }
     //   System.out.println(Arrays.toString(NoOfY));
        Arrays.sort(Y);
       int count=0;

       for(int i=0;i<m;i++){
           count+=NoOfCount(X[i],Y,n,NoOfY);
       }
        return count;
    }
    public static int NoOfCount(int x, int Y[], int n, int NoOfY[]){
        // If x is 0, then there cannot be any value in Y such that
        // x^Y[i] > Y[i]^x
        if (x == 0) return 0;

        // If x is 1, then the number of pais is equal to number of
        // zeroes in Y[]
        if (x == 1) return NoOfY[0];

        // Find number of elements in Y[] with values greater than x
        // getting upperbound of x with binary search
        int idx = Arrays.binarySearch(Y, x);
        int ans;
        if(idx < 0){
            idx = Math.abs(idx+1);
            ans = Y.length - idx;
        }
        else{
            while (idx<n && Y[idx]==x) {
                idx++;
            }
            ans = Y.length - idx;
        }

        // If we have reached here, then x must be greater than 1,
        // increase number of pairs for y=0 and y=1
        ans += (NoOfY[0] + NoOfY[1]);

        // Decrease number of pairs for x=2 and (y=4 or y=3)
        if (x == 2)  ans -= (NoOfY[3] + NoOfY[4]);

        // Increase number of pairs for x=3 and y=2
        if (x == 3)  ans += NoOfY[2];

        return ans;
    }


    public static void main(String[] args) {
        int X[] = {2, 1, 6};
        int Y[] = {1, 5};

        System.out.println("Total pairs = " + countPairs(X, Y, X.length, Y.length));
    }
}




