package Searching;

import java.util.HashMap;
import java.util.*;

public class CountOccurance {
	public int countOccurence(int[] arr, int n, int k) {
		// your code here,return the answer
		int checker = n / k;
		int res = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(i, hm.get(arr[i]) + 1);
			} else {
				hm.put(i, 1);
			}
		}
		for (Map.Entry<Integer, Integer> s : hm.entrySet()) {
			if (s.getValue() > checker) {
				res++;
			}
		}
		return res;
	}
//method 2
	

	// Prints elements with more than n/k occurrences in arr[] of
	// size n. If there are no such elements, then it prints nothing.
	static int countOccurence2(int arr[], int n, int k) {
		int count = 0;

		// k must be greater than 1 to get some output
		if (k < 2)
			return 0;
		/*
		 * Step 1: Create a temporary array (contains element and count) of size k-1.
		 * Initialize count of all elements as 0
		 */
		EleCount temp[] = new EleCount[k];

		for (int i = 0; i < k; i++)
			temp[i] = new EleCount();

		/* Step 2: Process all elements of input array */
		for (int i = 0; i < n; i++) {
			int j = 0;

			/*
			 * If arr[i] is already present in the element count array, then increment its
			 * count
			 */
			for (j = 0; j < k; j++) {
				if (temp[j].e == arr[i]) {
					temp[j].c += 1;
					break;
				}
			}

			/* If arr[i] is not present in temp[] */
			if (j == k) {
				int l = 0;

				/*
				 * If there is position available in temp[], then place arr[i] in the first
				 * available position and set count as 1
				 */
				for (l = 0; l < k; l++) {
					if (temp[l].c == 0) {

						temp[l].e = arr[i];
						temp[l].c = 1;
						break;
					}
				}

				/*
				 * If all the position in the temp[] are filled, then decrease count of every
				 * element by 1
				 */
				if (l == k)
					for (l = 0; l < k; l++)
						temp[l].c -= 1;
			}
		}

		/* Step 3: Check actual counts of potential candidates in temp[] */
		for (int i = 0; i < k; i++) {
			// Calculate actual count of elements
			int ac = 0; // actual count
			for (int j = 0; j < n; j++)
				if (arr[j] == temp[i].e)
					ac++;

			// If actual count is more than n/k, then print it
			if (ac > n / k)
				count++;
		}

		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
