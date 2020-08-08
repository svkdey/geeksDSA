package Sorting;

import java.util.Arrays;

public class InversionCount {
	static int merge(int arr[],int s,int e,int mid){
	    int count=0;
	    int i=s,k=s,j=mid+1;
	    int temp[]=new int[1000];
	    while(i<=mid && j<=e){
	        if(arr[i]>arr[j]){
	            //as it is coming from j to kth index .
	            // ie it will form inverison will all element btwn 
	             
	            count+=mid-i+1; //only here

	            temp[k++]=arr[j++];
	           
	            
	        }else{
	            temp[k]=arr[i];
	            k++;i++;
	        }
	    }
	    while(i<=mid){
	        temp[k++]=arr[i++];
	    }
	    while(j<=e){
	        temp[k++]=arr[j++];
	    }
	    for(int a=s;a<=e;a++){
	        arr[a]=temp[a];
	    }
	    return count;
	}


	static int inversionCountByMergeSort(int arr[],int s,int e){
	    if(s>=e) return 0;
	    
	    int mid=s+(e-s)/2;
	    //left hand side inversion count
	    int x=inversionCountByMergeSort(arr,s,mid);
	    //right hand side inversion count 
	    int y=inversionCountByMergeSort(arr,mid+1,e);
	    //merge sort inversion count

	    int z=merge(arr,s,e,mid);
	    
	    return x+y+z;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[] = {5, 6, 2, 4, 1, 9, 7, 100, 13, 25, 36, 46, 35, 88, 54, 67, 84, 27, 3, 13, 99};
	        int ans=inversionCountByMergeSort(a, 0, a.length - 1);
	        System.out.println(ans);
	        System.out.println(Arrays.toString(a));
	}

}
