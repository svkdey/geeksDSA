package LeetCode.InterviewPrep;

public class MajorityElement {
	 public int majorityElement(int[] nums) {
	        int candidate=findCandidate(nums);
	        int votes=0;
	        for(int i=0;i<nums.length;i++) {
	        	if(nums[i]==candidate) {
	        		votes++;
	        	}
	        }
	        return votes>=nums.length/2?candidate:-1;
	    }
	 
	 public int findCandidate(int[] nums) {
		 int currentVote=1;
		 int cur_element=nums[0];
		 for(int i=1;i<nums.length;i++) {
			 if(nums[i]==cur_element) {
				 currentVote++;
			 }else {
				 currentVote--;
			 }
			 if(currentVote==0) {cur_element=nums[i];currentVote=1;}
		 }
		 return cur_element;
	 }
}
