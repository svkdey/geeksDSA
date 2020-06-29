package LeetCode;

public class LeetCode53 {
	public static int solve(int[] nums) {
		
		 if(nums.length==0) return Integer.MIN_VALUE;
	        int arr[]=new int[nums.length];
			
			arr[0]=Math.max(Integer.MIN_VALUE, nums[0]);
			int ans=arr[0];
			for(int i=1;i<nums.length;i++) {
				arr[i]=Math.max(nums[i],arr[i-1]+nums[i]);
				ans=Math.max(ans, arr[i]);
			}
	        return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
