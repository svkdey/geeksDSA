package Sorting;

public class KthSmallestElement {
	static int kThSmallest(int arr[], int n, int k) {
		int startIdx = 0;
		int endIdx = n - 1;

		while (endIdx >= startIdx) {
			int p = PartitionTheories.lomutoPartition(arr, startIdx, endIdx);
			if (p == k - 1)
				return arr[p];
			else if (p > k - 1)
				endIdx = p - 1;
			else
				startIdx = p + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,8,4,5,6,7};
		System.out.println(kThSmallest(arr,arr.length,3));
	}

}
