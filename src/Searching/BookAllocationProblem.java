package Searching;

public class BookAllocationProblem {
	
	public static boolean ifPossible(int arr[],int n,int m,int mid) {
		int student=1;
		int pagesReading=0;
		for(int i=0;i<n;i++) {
			//for next student 
			if (arr[i] > mid) 
                return false;
			if(pagesReading+arr[i]>mid) {
				student++;
				pagesReading=arr[i];
				if(student>m) {
					return false;
				}
			}else {
				//for current student 
				pagesReading+=arr[i];
			}
		}
		return true;
	}
	public static int solve(int arr[], int n, int m) {
		if (m > n) {
			return -1;
		}
		int sum = 0;
		for (int x : arr) {
			sum += x;
		}
		int s = arr[n - 1];
		int e = sum;
		int ans=Integer.MAX_VALUE;
		while(e>=s) {
			int mid=s+(e-s)/2;
			
			if(ifPossible(arr,n,m,mid)) {
				ans=Math.min(ans, mid);
				e=mid-1;
			}else{
				s=mid+1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,20,40,50};
		int n=arr.length;
		int m=3;
		
		System.out.println(solve(arr,n,3));
	}

}
