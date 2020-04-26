package Searching;

public class MedianOfTwoSortedArray {
	//assume B>=A in size
	//do binary search in A arrray ,and mid is i1
	//make  arr1 and arr2
	//mid of B , i2=[(n1+n2+1)/2 -i1]
	//0 to i2-1 and i2-n2 
	
	static double medianOfTwoSortedArray(int A[],int B[]) {
		int n1=A.length,n2=B.length;
		int begin1=0;int end1=n1;
		
		while(begin1<=end1) {
			int i1=begin1+(end1-begin1)/2;
			int i2=(n1+n2+1)/2-i1;
			
			int min1= i1==n1?Integer.MAX_VALUE:A[i1];
			int max1=i1==0?Integer.MIN_VALUE:A[i1-1];
			
			int min2= i2==n2?Integer.MAX_VALUE:B[i2];
			int max2=i2==0?Integer.MIN_VALUE:B[i2-1];
			
			if(max1<=min2 &&max2<=min1) {
				if((n1+n2)%2==0) {
					return (double)( Math.max(max1, min2)+Math.max(min1, max2))/2;
				}else {
					return (double) Math.max(max1, min2);
				}
			} else if(max1>min2) {
				end1=i1-1;
			}else {
				
				
				begin1=i1+1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
