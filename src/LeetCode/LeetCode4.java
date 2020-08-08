package LeetCode;

public class LeetCode4 {
	public static int findMedian(int arr[], int n, int brr[], int m){
	    //Your code here
	   
	    if(n > m){
	    	return findMedianUtil(arr, n, brr, m);
	    }
	    else{
	    	return findMedianUtil(brr, m,arr,n);
	    }

	   
	}
	public static int findMedianUtil(int arr1[],int n,int arr2[],int m){
		
		  
		    int low = 0; int high = Math.min(n,m)-1; int i1=0; int i2 = 0;
		    int max1 = 0 ; int max2 = 0; int min1 = 0; int min2 = 0;
		    while(low <= high){
		        i1 = (low+high)/2;
		        i2 = (n+m+1)/2 - i1;
		        min1 = (i1 > n-1)? Integer.MAX_VALUE:arr1[i1];
		        max1 = (i1 == 0)? Integer.MIN_VALUE:arr1[i1-1];
		        min2 = (i2 > m-1)? Integer.MAX_VALUE:arr2[i2];
		        max2 = (i2 == 0)? Integer.MIN_VALUE:arr2[i2-1];

		        if(min1 >= max2 && min2 >= max1){
		            if((n+m)%2==0)
		                return (Math.max(max1,max2)+Math.min(min1,min2))/2;
		            else
		                return (Math.min(min1,min2));
		        }else{
		            if(max2 > min1)
		                low = i1+1;
		            else
		                high = i1-1;
		        }
		    }
		    return -1;
	}
	public static void main(String[] args) {
		int nums1[] = {1, 3};
		int	nums2[] = {2};
		findMedian(nums2,nums2.length,nums1,nums1.length);
	}
}
