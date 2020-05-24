package Searching;
/**
 Closer to sort
 Given an array arr[] of N integers which is closer sorted (defined below) and an element x. The task is to find index of the element x if it is present. If not present, then print -1.
 Closer Sorted: First array is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e, may be to the arr[i+1] or arr[i-1].

 Expected Time Complexity: O(Log N)

 Input:
 First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array. Next line contains the array elements. Last line contains the element to be searched.

 Output:
 Output the index at which the element is present (0-based), if present, else print "-1".

 Your Task:
 This is a function problem. You only need to complete the function closer() that arr, N, and x as parameters and returns the index. If element is not present, return -1.

 Constraints:
 1 <= T <= 100
 1 <= N <= 106
 1 <= arr[i],x <= 106

 Example:
 Input:
 2
 5
 3 2 10 4 40
 2
 4
 2 1 4 3
 5
 Output:
 1
 -1

 Explanation:
 Testcase 1: 2 is present at index 1 (0-based indexing) in the given array.
 Testcase 2: 5 is not in the array so the output will be -1.

 Note: You may assume that the array does not contain any duplicate elements.
  **/
public class CloserToSort {
    static long closer(int a[], int n, long x)
    {
        // add your code here
        int s=0,e=n-1,mid;
        while(s<=e)
        {
            mid=s+(e-s)/2;
            if(a[mid]==x)
                return mid;
            else if(mid+1<n && a[mid+1]==x)
                return mid+1;
            else if(mid-1>=0 && a[mid-1]==x)
                return mid-1;
            else if(x>a[mid])
                s=mid+2;
            else
                e=mid-2;
        }
        return -1;
    }
}
