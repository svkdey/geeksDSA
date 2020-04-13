package Recursion;

public class JoshepProblem {
	public static int joshepProblem(int n,int k) {
		if(n==1) return 0;
		return (joshepProblem(n-1, k)+k)%n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(joshepProblem(7, 3));
		System.out.println(joshepProblem(5, 3));
	}

}
