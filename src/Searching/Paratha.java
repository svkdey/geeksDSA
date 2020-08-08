package Searching;

//spoj pratha problem
public class Paratha {
	
	public static boolean isPossible(int numberOfparatha,int cooks[],int cookNumber,int time) {
		int total=0;
		for(int i=0;i<cookNumber;i++) {
			int allotatedTime=time; int count=0;
			int j=1;
//			allotatedTime-=cooks[i];
			while(allotatedTime-j*cooks[i]>=0) {
				allotatedTime-=j*cooks[i];
				
				count++;j++;
			}
			total+=count;
			if(total>=numberOfparatha) {
				return true;
			}
		}
//		System.out.println(total);
		return false;
	}
	
	public static int solve(int numberOfparatha,int cooks[],int cookNumber) {
		int n=numberOfparatha;
		int s=0;int e=(cooks[0]*n*(n-1))/2;
		//minimum time = ans
		int ans=-1;
		while(e>=s) {
			int mid=s+(e-s)/2;
			
			boolean isPossbleInMidTime=isPossible(numberOfparatha,cooks,cookNumber,mid);
		System.out.println(isPossbleInMidTime+ " mid"+ mid);
			if(isPossbleInMidTime) {
				ans=mid;
				e=mid-1;
				
			}else {
				
				s=mid+1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int paratha=10;
		int cooks[]= {1,2,3,4};
		int n=4;
//		System.out.println(isPossible(paratha, cooks, n,10));
//		System.out.println(isPossible(paratha, cooks, n,11));
//		System.out.println(isPossible(paratha, cooks, n,12));
//		System.out.println(isPossible(paratha, cooks, n,13));
//		System.out.println(isPossible(paratha, cooks, n,14));
//		System.out.println("-------------------------------------");
		System.out.println(solve(paratha, cooks, n));

	}

}
