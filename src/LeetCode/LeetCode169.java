package LeetCode;

public class LeetCode169 {
	 public int majorityElement(int[] nums) {
	      //set 1 find candidate
		 	int candidate=findCandidate(nums);
		 //2 validate candidate
		 	boolean validCandidate=validCandidate(candidate,nums);
		 	return validCandidate?candidate:-1;
	    }
	 private int findCandidate(int[] nums) {
		int candidate=nums[0];
		int count=1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]==candidate) {
				count++;
			}else {
				count--;
			}
			if(count==0) {
				candidate=nums[i];count=1;
			}
		}
		return candidate;

	}
	 private boolean validCandidate(int candidate, int[] nums){
		 int count=0;
		 for(int i=0;i<nums.length;i++) {
			 if(nums[i]==candidate) {
				 count++;
			 }
		 }
		 return count>(nums.length/2);
	}
}
