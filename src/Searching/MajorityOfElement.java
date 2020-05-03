package Searching;

import Data.ArrayData;

public class MajorityOfElement {
	static int majorityElement(int a[], int size)
    {
        // your code here
        int count[]=new int[1000];
        int maxValue=0;
        int maxOccurance=0;
        
        for(int i=0;i<size;i++){
            count[a[i]]++;
            maxOccurance=Math.max(maxOccurance,count[a[i]]);
            maxValue=Math.max(maxValue,a[i]);
        }
        if(maxOccurance==1){
            return -1;
        }
        else{
           for(int i=0;i<maxValue;i++){
               if(count[i]==maxOccurance) return i;
           } 
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(majorityElement(ArrayData.majority,ArrayData.majority.length ));
	}

}
