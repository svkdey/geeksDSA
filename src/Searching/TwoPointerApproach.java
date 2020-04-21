package Searching;

public class TwoPointerApproach {
	public static int[] twoPointerApproach(int[] arr, int start, int size, int sum) {
		int i = start;
		int j = size - 1;
		int res[] = { -1, -1 };
		while (j >= i) {
			if (arr[i] + arr[j] > sum) {
				j--;
			}
			if (arr[i] + arr[j] == sum) {
				res[0] = i;
				res[1] = j;
				return res;
			} else {
				i++;
			}
		}
		return res;
	}

	/*
	 * naive solution : for(i to n){
	 *  for(j=i+1 to n) {
	 *   for(k=j+1 to n){
	 *   //code...
	 *    } } }
	 */
	public static void findTriplet(int[] arr, int size, int sum) {
//		best solution	
		for (int i = 0; i < size - 1; i++) {
			int[] res = twoPointerApproach(arr, i + 1, size, sum - arr[i]);
			if (res[0] != -1 && res[1] != -1) {
				System.out.println("i:" + arr[i] + " j:" + arr[res[0]] + " k:" + arr[res[1]]);
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// array must be sorted
		int arr[] = { 1, 3, 4, 12, 16 };
//		int[] res = twoPointerApproach(arr, 5, 13);
//		System.out.println(res[0] + " " + res[1]);
		findTriplet(arr, 5, 19);
	}

}
