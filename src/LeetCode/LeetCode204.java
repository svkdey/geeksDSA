package LeetCode;

import java.util.Arrays;

public class LeetCode204 {
	 public static int countPrimes(int n) {
	        boolean isPrime[]=new boolean[n+1];
	        Arrays.fill(isPrime,true);
	        int ans=0;
	        for(int i=2;i*i<n;i++ ){
	            if(isPrime[i]){
	                for(int j=i*i;j<n;j+=i){
	                    isPrime[j]=false;
	                }
	            }
	        }
	       for(int i=2;i<n;i++ ){
	           if(isPrime[i]){
	               ans++;
	           }
	       }
	        System.out.println(Arrays.toString(isPrime));
	        System.out.println(ans);
	        return ans;
	    }
	 public static void main(String[] args) {
		countPrimes(10);
	}
}
