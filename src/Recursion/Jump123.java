package Recursion;

public class Jump123 {
	//if {2,1,1,}---> {1,2,1}--->{1,1,2} all considered as same.
	//this is same as coin change problem,
	int step(int arr[],int n,int target){
	    if(target<0) return 0;
	    if(target==0) return 1;
	    if(target>0&&n<0) return 0;
	    else return step(arr,n,target-arr[n-1])+step(arr,n-1,target);

	}
	
	//if {2,1,1,}---> {1,2,1}--->{1,1,2} all considered as different.
	int stepMultiple(int arr[],int n,int target){
	    if(target<0) return 0;
	    if(target==0) return 1;
	    int ans=0;
	    for(int i=0;i<n;i++ ){
	    
	        ans+=stepMultiple(arr,n,target-arr[i]);
	    }
	    return ans;

	}
	
	
	int stepMultiple(int target){
	    if(target<0) return 0;
	    if(target==0) return 1;
	    return stepMultiple(target-1)+stepMultiple(target-2)+stepMultiple(target-3);

	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
