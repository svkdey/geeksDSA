package LeetCode;

public class LeetCode503 {
	static class Mapping {
		int element;
		int id;
		public Mapping(int element, int id) {
			super();
			this.element = element;
			this.id = id;
		}
		
	}
	 public int[] nextGreaterElements(int[] nums) {
	        int n=nums.length;
	        int result[]=new int[n];
	        Mapping map[]=new Mapping[n];
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<n;i++) {
	        	map[i]=new Mapping(nums[i],i);
	        	max=Math.max(max,nums[i]);
	        }
	        for(int i=0;i<n;i++) {
	        	Mapping m=map[i];
	        	if(m.element==max) {
	        		result[i]=-1;
	        	}
	        	else if(m.id==n-1) {
	        		for(int j=0;j<n;j++) {
	        			if(nums[j]>m.element) {
	        				result[i]=nums[j];
	        				break;
	        			}
	        		}
	        	}else {
	        		int ans=-1;
	        		for(int j=m.id;j<n;j++) {
	        			if(nums[j]>m.element) {
	        				ans=nums[j];
	        				break;
	        			}
	        		}
	        		if(ans==-1) {
	        			for(int j=0;j<n;j++) {
		        			if(nums[j]>m.element) {
		        				ans=nums[j];
		        				break;
		        			}
		        		}
	        		}
	        		result[i]=ans;
	        	}
	        }
	        return result;
	   }
}
