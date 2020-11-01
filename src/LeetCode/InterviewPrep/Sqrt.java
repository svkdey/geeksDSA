package LeetCode.InterviewPrep;

public class Sqrt {
	 public static int mySqrt(int x) {
	        long start=1;
	        long end=x-1;
	        long ans=-1;
	        while(end>start){
	            long mid=start+(end-start)/2;
	            System.out.println(mid);
	            if(mid*mid<=(long)x){
	                ans=mid;
	                start=mid+1;
	            }else{
	                end=mid;
	            }
	        }
	        return (int)ans;
	    }
	 public static void main(String[] args) {
		 System.out.println(mySqrt(4));
	}
}
