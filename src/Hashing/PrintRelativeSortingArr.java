package Hashing;

import java.util.Map;
import java.util.TreeMap;

import Data.ArrayData;

public class PrintRelativeSortingArr {
	
	 static void printRelativeSortedArray(int [] arr1,int [] arr2) {
		 Map<Integer, Integer> lookup = new TreeMap<>(); // map to keep count in sorted order
         for(int e: arr1) {
             lookup.merge(e, 1, Integer::sum); // if exist increment count
         }
         for(int e: arr2) {
             if(lookup.containsKey(e)) {
                 while(lookup.get(e) > 0) {
                     System.out.print(e + " ");
                     lookup.merge(e, -1, Integer::sum);
                 }
                 lookup.remove(e);
             }
         }
         for(int e: lookup.keySet()) {
             while(lookup.get(e) > 0) {
                     System.out.print(e + " ");
                     lookup.merge(e, -1, Integer::sum);
                 }
		    }
         System.out.println(); 
         }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printRelativeSortedArray(ArrayData.relativeSortArr3, ArrayData.relativeSortArr4);
	}

}
