package Recursion;

public class OptimalBinarySearch {
	
	/*
	 *If last bit is 0 then number of ways is f(n)=f(n-1) OR
	 *if last bit is 1 then n-1 bit has to  0 then f(n)=f(n-2)
	 *so f(n)=f(n-1)+f(n-2)
	 */
//	f(n+2) ->fibonachi series
	public static int solve(int n) {
		if(n==0) return 0;
		if(n==1) return 2;
		if(n==2) return 3;
		else return solve(n-1)+solve(n-2);

	}

	public static void main(String[] args) {
		System.out.println(solve(2));
		System.out.println(solve(3));
	}
}
// 0 0 0
// 0 0 1
// 0 1 0
// 1 0 0
// 1 0 1
