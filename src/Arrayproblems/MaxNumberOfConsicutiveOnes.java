package Arrayproblems;

public class MaxNumberOfConsicutiveOnes {
	//O(n)
	public static int maxNumberOfConsicutiveOnes(int[] arr, int n) {
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == 1) {
				count++;
			} else {
				maxCount = Math.max(count, maxCount);
				count = 0;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 1,1,0,0,1, 1,1, 1, 0, 1 };
		int [] arr2= {0,0,0};
		System.out.println(maxNumberOfConsicutiveOnes(arr2, 3));
	}

}
