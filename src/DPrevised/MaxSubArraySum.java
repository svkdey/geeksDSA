package DPrevised;

import java.util.Arrays;

public class MaxSubArraySum {
	
	public static int maxSubArraySum(int arr[],int idx) {
		if(idx==0) return arr[idx];
		
		int include = 0,exclude=0;
		include+=arr[idx]+maxSubArraySum(arr, idx-1);
		exclude+=maxSubArraySum(arr, idx-1);

		return Math.max(include,exclude);
		
	}

	public static int bottomUp(int arr[],int idx) {
		int temp[]=new int[100];
		
		temp[0]=arr[0]>0?arr[0]:0;
		int maxSofar=temp[0];
		
		
		
		for(int i=1;i<arr.length;i++) {
			temp[i]=temp[i-1]+arr[i];
			if(temp[i]<0) {
				temp[i]=temp[i-1];
			}
			maxSofar=Math.max(temp[i],maxSofar);
		}
		return maxSofar;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {-3,2,5,-1,6,3,-2,7,-5,2};
//		System.out.println(maxSubArraySum(arr, arr.length-1));
		
		System.out.println(maxSubArraySum(arr, arr.length-1));
		
		
	}

}
