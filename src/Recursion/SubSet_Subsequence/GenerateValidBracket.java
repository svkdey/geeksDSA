package Recursion.SubSet_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateValidBracket {
	//number of closing bracket should be equal to number of open bracket
	
	//open>=close at a time . 
	//max open bracket =N 
	public static void solve(int idx,int openCount,int closeCount,int N,char arr[]) {
		if(idx==2*N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		//both condition are independent
		
		if(openCount<N) {
			arr[idx]='(';
			solve(idx+1, openCount+1, closeCount, N, arr);
		}
		
		if(closeCount<openCount) {
			arr[idx]=')';
			solve(idx+1, openCount, closeCount+1, N, arr);
		}
		return;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[]=new char[6];
		solve(0,0,0,3,arr);
	}

}
