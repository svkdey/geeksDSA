package PracticeGround;

public class PickFinded {
	static int findPick(int arr[], int n) {
		int start=0;
		int end=n-1;
		while(end>start) {
			int mid=start+(end-start)/2;
			if(arr[mid]<arr[mid+1]) {
				start=mid+1;
			}else {
				end=mid;
			}
		}
		return start;
	}
	 static int findPeakUtil(int arr[], int low, int high, int n) 
	    { 
	        // Find index of middle element 
	        int mid = low + (high - low)/2;  /* (low + high)/2 */
	  
	        // Compare middle element with its neighbours (if neighbours 
	        // exist) 
	        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || 
	             arr[mid+1] <= arr[mid])) {
	            return mid; 
	        }
	        // If middle element is not peak and its left neighbor is 
	        // greater than it,then left half must have a peak element 
	        else if (mid > 0 && arr[mid-1] > arr[mid]) 
	            return findPeakUtil(arr, low, (mid -1), n); 
	  
	        // If middle element is not peak and its right neighbor 
	        // is greater than it, then right half must have a peak 
	        // element 
	        else return findPeakUtil(arr, (mid + 1), high, n); 
	    } 
	  
	    // A wrapper over recursive function findPeakUtil() 
	    static int findPeak(int arr[], int n) 
	    { 
	        return findPeakUtil(arr, 0, n-1, n); 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-1,2,1};
		System.out.println(findPick(arr, arr.length));
	}

}
