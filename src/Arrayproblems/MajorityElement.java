package Arrayproblems;

public class MajorityElement {
	// naive solution :an element in array will be called majority if it's frequency
	// of occurance is n/2;

	public static int majorityElement(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > n / 2) {
				return i;
			}
		}
		return -1;

	}

	// best solution :an element in array will be called majority if it's frequency
	// of occurance is n/2;
//	more's solution.
	
	//algo 1.find a candidate by its index .
	//2.check if its a majority or not
	
	public static int majorityElementTwo(int[] arr, int n) {
//		lets  index =0 is majority
//		and check if any other majority
		int res = 0, count = 1;
		for (int i = 0; i < n; i++) {
			if (arr[res] == arr[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				res = i;
				count = 1;
			}
		}
		count = 0;
//		System.out.println(res);
		for (int i = 0; i < n; i++) {
			if (arr[res] == arr[i]) {
				count++;
			}

		}
		if (count <= n / 2) {
			res = -1;
		}
		return count;

	}
//	public static int majorityElementThree(ArrayList<Integer> arr, int n) {
//		HashSet<Integer,Integer> set=HashSet<E>
//		
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 1 ,3, 3 };
		int n = 5;
		System.out.println(majorityElementTwo(arr, n));
	}

}
