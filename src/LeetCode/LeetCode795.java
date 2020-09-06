package LeetCode;

public class LeetCode795 {
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		return maxNumber(A,R)-maxNumber(A,L-1);
	}
	public int maxNumber(int[] A, int b) {
		int ans=0,pre=0,n=A.length;
		for(int i=0;i<n;i++) {
			if(A[i]>b) {
				pre=i+1; //invalid subset
			}else {
				ans+=i+1-pre; // i+1 is the number of subset it can produce
			}
		
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		LeetCode795 s = new LeetCode795();
		int a[] = { 2, 9, 2, 5, 6 };
		s.numSubarrayBoundedMax(a, 2, 8);

	}
}
