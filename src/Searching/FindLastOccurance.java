package Searching;

public class FindLastOccurance {
	public static int solve(int arr[], int n, int k) {
		int s = 0;
		int e = n - 1;
		int ans=-1;
		while (s<=e) {
			int m = s+((e -s) / 2);
			if (arr[m] == k) {
				ans=m;
				s=m+1; //keep on searching on rightj
				
			} else if (arr[m] > k) {
				e = m - 1;
			} else {
				s = m + 1;
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,4,4,5,6,7,10,11,12,13};
		System.out.println(solve(arr, arr.length, 4));
	}

}
