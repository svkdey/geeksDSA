package Searching;

public class WinningCBcoupon {
	public static int solve(int N,int totalCoupon,int x,int y) {
		int s=0;
		int e=x*N;
		int ans=-1;
		while(e>=s) {
			int mid=s+(e-s)/2;
			if(mid*x<=totalCoupon+(N-mid)*y) {
				ans=mid;
				s=mid+1;
			}else {
				e=mid-1;
			}
		}
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(5, 11, 3, 1));
	}

}
