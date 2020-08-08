package LeetCode;

public class Leet1013 {
	public boolean canThreePartsEqualSum(int[] A) {
        if(A.length==0) return false;
        int sum=0;
        for(int x:A) {
        	sum+=x;
        }
        if(sum%3!=0) {
        	return false;
        }
        int target=sum/3;
        int c=0;
        sum=0;
       
        for(int x:A) {
        	sum+=x;
        	if(sum==target) {
        		c++;
        		sum=0;
        	}
        }
       if(target==0) {
    	   return c>=3?true:false;
       }else {
    	   return c==3?true:false;
       }
        
    }
}
