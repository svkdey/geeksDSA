package Searching;
//vvi  qstn
public class AggresiveCows {
	static boolean findvalid(int stalls[],int cows,int n,int separation) {
//		lets  assume 1st cow is at stall 0
		int count=1;
		int lastCow=stalls[0];
		for(int i=1;i<n;i++ ) {
			if(stalls[i]-lastCow>=separation) {
				count++;
				lastCow=stalls[i];
				if(count==cows) {
					return true;
				}
			}
			
		}
		return false;
	}
	public static int solve(int stalls[],int cows,int n) {
		int s=0;
		int e=stalls[n-1]-stalls[0];
		
		
		int ans=-1;
		while(e>=s) {
			int mid=s+((e-s)/2);
			
			boolean isValidConfig=findvalid(stalls,cows,n,mid);
			if(isValidConfig) {
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
		int stalls[]= {1,2,4,8,9};
		int n=5;
		int cows=3;
		
		System.out.println(solve(stalls, cows, n));
	}

}
