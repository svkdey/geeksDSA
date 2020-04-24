package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class DistinctElementInNwindows {
	//o(n^2) solution 
	static int findDistinctElement(int [] arr,int start,int end) {
		HashSet<Integer> s=new HashSet<Integer>();
		
		for(int i=start;i<end;i++) {
			s.add(arr[i]);
		}
		return s.size();
	}
	static void findDistinctElementInNwindowsSol1(int [] arr,int k) {
		for(int i=0;i<arr.length-k+1;i++) {
			System.out.println(">>"+i+ " "+ (i+k));
			System.out.println(findDistinctElement(arr,i,i+k));
		}
	}
	//o(n) solution with hashmap and sliding window technique
	static void findDistinctElementInNwindowsSol2(int [] arr,int k) {
		HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
		for (int i = 0; i <k; i++) {
			if (!m.containsKey(arr[i])) {
				m.put(arr[i], 1);
			} else {
				m.put(arr[i], (m.get(arr[i]) + 1));
			}
		}
		System.out.println(m);
		System.out.println(m.size());
		for (int i = k; i <arr.length; i++) {
			//make i-k th element frequency -1
			
			m.put(arr[i-k], (m.get(arr[i-k]) - 1));
			//check if only occured once 
			//if i-k th frequncy ==0,remove the element
			if(m.get(arr[i-k])==0) {
				m.remove(arr[i-k]);
			}
			//add or update i th element in hashmap 
			if (!m.containsKey(arr[i])) {
				m.put(arr[i], 1);
			} else {
				m.put(arr[i], (m.get(arr[i]) + 1));
			}
			//printō
			System.out.println(m);
			System.out.println(m.size());
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findDistinctElementInNwindowsSol1(new int[] { 10,20,20,10,30,40,10 },4);
		System.out.println("-------------------------------------------------------------------------------------------------");
		findDistinctElementInNwindowsSol2(new int[] { 10,20,20,10,30,40,10 },4);
	}

}
