package LeetCode;

public class LeetCode34 {
	public int lIdx(int[] nums, int target) {
		int start=0;int end=nums.length-1;
		int ans=-1;
		while(end>=start) {
			int mid=start+(end-start)/2;
			if(nums[mid]==target) {
				ans=mid;
				end=mid-1;
			}
			else if(nums[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
			
		}
		return ans;
	}
	public int rIdx(int[] nums, int target) {
		int start=0;int end=nums.length-1;
		int ans=-1;
		while(end>=start) {
			int mid=start+(end-start)/2;
			if(nums[mid]==target) {
				ans=mid;
				start=mid+1;
			}
			else if(nums[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
			
		}
		return ans;
	}
	public int[] searchRange(int[] nums, int target) {
			int l=lIdx(nums, target);
			int r=rIdx(nums, target);
			System.out.println(l+"-->"+r);
			return new int[] {l,r};
			
	}
	public static void main(String[] args) {
		int nums[] = {5,7,7,8,8,10}, target = 8;
		
	}
}
