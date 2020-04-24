package Hashing;

import java.util.LinkedHashMap;

public class MaxLengthSubarrayToTargetSum {
	public static int maxLengthSubarrayToTargetSum(int [] arr,int target) {
		LinkedHashMap<Integer,Integer> set=new LinkedHashMap<Integer,Integer>();
		
		int prefixSum=0;
		int maxLen=0;
		for(int i=0;i<arr.length;i++) {
			prefixSum+=arr[i];
			if(set.containsKey(prefixSum-target)) {
				int idx=set.get(prefixSum-target);
				maxLen=Math.max(i-idx, maxLen);
			}
			if((prefixSum-target)==0){
				maxLen=Math.max(i+1, maxLen);
			}else {
				set.put(prefixSum,i);
			}
		}
		System.out.println(set);
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(maxLengthSubarrayToTargetSum(new int[] {5,8,-4,-4,9,-3,3}, 0));
	}

}
