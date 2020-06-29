package stringDSA;

import java.util.Arrays;

public class LeetCode3 {
	public static int lengthOfLongestSubstring(String s) {
        int arr[]=new int[256];
        
        int i=0;
        int result=Integer.MIN_VALUE;
        int count=0;
        int j=0;
        while(i<s.length()){
            if(arr[(int)s.charAt(i)]!=1){
               
                arr[(int)s.charAt(i)]++;
                i++;count++;
            }else{
              result=Math.max(result,count);
                count=0;
                i=j+1;
                j=i;
                Arrays.fill(arr,0);
            }
        }
        
        	 result=Math.max(result,count);
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
	
}
