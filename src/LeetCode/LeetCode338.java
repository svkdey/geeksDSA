package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode338 {
	public static int[] countBits(int num) {
       int ans[]=new int[num+1];
        for(int i=0;i<=num;i++){
            int n=i;
            int k=0;
            while(n!=0){
                if((n&1)==1){
                   k++;
                }
                n=n>>>1;
            }
            ans[i]=k;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
	
	public static int[] countBitsBetterApporach(int num) {
	       int ans[]=new int[num+1];
	       ans[0]=0;
	        for(int i=1;i<=num;i++){
	            int remBits=i&(i-1);
	            ans[i]=ans[remBits]+1;
	        }
	        System.out.println(Arrays.toString(ans));
	        return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		countBitsBetterApporach(5);
	}

}
