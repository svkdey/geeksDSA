package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * We have to paint n boards of length {A1, A2…An}. There are k painters available and each takes 1 unit time to paint 1 unit of board.
 *  The problem is to find the minimum time to get
this job done under the constraints that any painter will only paint continuous sections of boards,
 say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 
 Input : k = 2, A = {10, 10, 10, 10} 
Output : 20.
Here we can divide the boards into 2
equal sized partitions, so each painter 
gets 20 units of board and the total
time taken is 20. 

Input : k = 2, A = {15, 20, 30, 40} 
Output : 60.
Here we can divide first 3 boards for
one painter and the last board for 
second painter.
 *
 **/
public class PainterAllocation {
	
	private static boolean isPossibleToPaint(int arr[],int k,int n,int time) {
		int painterCount=1;
		int allocationTime=arr[0];
		for(int i=1;i<n;i++) {
			if (arr[i] > time) 
                return false; 
			if(allocationTime+arr[i]<=time) {
				allocationTime+=arr[i];
			}else {
				painterCount++;
				allocationTime=arr[i];
				if(painterCount>k) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	public static int solve(int arr[],int k,int n) {
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
//		
		int e=0;
		int s=0;
	
		for (int x : arr) {
			e += x;
			s=Math.max(s,x);
		}
		int ans=s;
		while(e>=s) {
			int mid=s+(e-s)/2;
			
			if(isPossibleToPaint(arr,k,n,mid)) {
				ans=Integer.min(ans, mid);
				e=mid-1;
			}else {
				s=mid+1;
			}
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(sc.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(sc.readLine());

			int arr[] = new int[n];
			String s[]=sc.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			int k= Integer.parseInt(sc.readLine());
			solve(arr,k,n);
		}
	}

}
