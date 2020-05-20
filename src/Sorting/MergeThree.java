package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MergeThree
{
    // Function to merge three sorted arrays
    // A[], B[], C[]: input arrays
    static void copy(int src[],int dist[]){
        for(int i=0;i<src.length;i++){
            dist[distIdx]=src[i];
            distIdx++;
        }
    }
    static int distIdx=0;
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        // add ypur code here
        int newArray[]=new int[A.length+B.length+C.length];
        
        copy(A,newArray);
        copy(B,newArray);
        copy(C,newArray);
        mergeSort(newArray,0,newArray.length-1);
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i:newArray) {
        	list.add(i);
        }
        return list;
        
    }
    static void mergeSort(int arr[],int start,int end){
        if(end>start){
            int mid=start+(end-start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            
            merge(arr,start,mid,end);
        }
    }
       static void merge(int arr[],int start,int mid,int end){
           int n=mid-start+1;
           int m=end-mid;
            int left[]=new int[n];
            for(int i=0;i<n;i++){
                left[i]=arr[start+i];
		}
            int right[]=new int[m];
            for(int i=0;i<m;i++){
                right[i]=arr[mid+i+1];
            }
           
            int i=0;int j=0;int k=start;
            
            while(i<n&&j<m){
                if(left[i]>right[j]){
                    arr[k]=right[j];j++;k++;
                }else{
                    arr[k]=left[i];i++;k++;
                }
            }
            while(i<n){
                arr[k]=left[i];i++;k++;
            }
            while(j<m){
                arr[k]=right[j];j++;k++;
            }
       }
       public static void main(String[] args) {
    	   int arr1[]= {1 ,2 ,3 ,4};
    	   int arr2[]= {1 ,2, 3, 4, 5};
    		int arr3[]= {1 ,2 ,3 ,4 ,5,6};
    		merge3sorted(arr1,arr2,arr3);
	}
       
      //approach 2 is
     /*  a b c
       merge a b => d 
       merge d c
       */
}

