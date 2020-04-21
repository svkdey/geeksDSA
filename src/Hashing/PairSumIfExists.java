package Hashing;

import java.util.HashMap;

public class PairSumIfExists {
	public static void pairSumInArray(int arr[],int target) {
		// TODO Auto-generated method stub
		boolean flag=false;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(target-arr[i], arr[i]);
			}else {
//				System.out.println(map);
				System.out.println(arr[i]+"   "+map.get(arr[i]));
				flag=true;
			}
		}// System.out.println("does not exists");
		System.out.println(map);
		System.out.println(flag);
		
		
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pairSumInArray(new int[] { 11,5,6},10);
	}

}
