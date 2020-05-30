package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubarrayWithEqualNumberZeroAndOne {
	static int longestSubarrayWithEqualNumberZeroAndOne(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prefixSum = 0;
		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				prefixSum += -1;
			} else {
				prefixSum += 1;
			}

			if (prefixSum == 0) {
				maxLength = i + 1;
			}


			if (map.containsKey(prefixSum)) {
				int idx = map.get(prefixSum);

				maxLength = Math.max(i - idx, maxLength);
			} else {
				map.put(prefixSum, i);
			}
		}
		return maxLength;
	}

	static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
		// add your code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prefixSum = 0;
		int count = 0;
		//map.put(prefixSum, count);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				prefixSum += -1;
			} else {
				prefixSum += arr[i];
			}
			if(prefixSum==0) {
				count++;
			}
			if(map.containsKey(prefixSum)) {
				count+=map.get(prefixSum);


				map.put(prefixSum,map.get(prefixSum)+1);
			}
			else {
				map.put(prefixSum,1);
			}

		}
		return count;

	}
	 static void findPairEqual0 (int arr[]){
		
      	HashSet<Integer> s = new HashSet<Integer>();
      	ArrayList<Integer> l=new ArrayList<>();
      	
      	for(int i=0;i<arr.length;i++) {
      		s.add(arr[i]);
      		if(arr[i]>0) {
      			l.add(arr[i]);
      		}
      	}
      	Collections.sort(l);
      	for(Integer i:l) {
      		int val=-1*i;
      		if(s.contains(val)) {
      			System.out.print(i+" "+val+" ");
      		}
      	}
      	System.out.println();
      	
      	
  } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findPairEqual0(new int[] {1, 3, 6 ,-2 ,-1 ,-3, 2 ,7});

	}

}
