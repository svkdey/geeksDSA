package Hashing;

import java.util.*;

public class FindlengthOflongestSubSequence {
	static int findLongestConseqSubseq(int arr[], int n) {
		// add your code here
		int maxVal = arr[0], minVal = arr[0];
		HashSet<Integer> hm = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
			if (arr[i] < minVal) {
				minVal = arr[i];
			}
			
				hm.add(arr[i]);
		

		}
	   System.out.println(hm+" "+minVal+" "+maxVal);
		int count = 0, currentCount = 0;
		for (int i = minVal; i <= maxVal; i++) {
			if (hm.contains(i)) {
				currentCount++;
			} else {
				count = Math.max(count, currentCount);
				currentCount = 0;

			}
		}
		count = Math.max(count, currentCount);
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLongestConseqSubseq(new int[] { 8 ,8 ,9 ,9 ,3 ,4}, 6));
	}

}
