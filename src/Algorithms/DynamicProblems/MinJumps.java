package Algorithms.DynamicProblems;

import java.util.Arrays;

public class MinJumps {
    public static int minJumps(int arr[],int n){
        if(n==1) return 0;
        int res=Integer.MAX_VALUE;
        //find i values for which we can reach to n-1
        //for those i value if there exists a 0 to i+1 path?

        for(int i=0;i<=n-2;i++){
            if(i+arr[i]>=n-1){
                int sub_res=1+minJumps(arr,i+1);
                if(sub_res!=Integer.MAX_VALUE){
                    res=Math.min(res,sub_res);
                }
            }
        }
        return res;
    }
    public static int minJumpsDP(int arr[],int n){
        int dp[]=new int[n];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
//        System.out.println(Arrays.toString(dp));
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]+j>=i){

                    if(dp[j]!=Integer.MAX_VALUE){
                        System.out.println(Arrays.toString(dp));
                        dp[i]=Math.min(dp[i],dp[j]+1);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];

    }

    public static void main(String[] args) {
        int[] jumps={3,2,1,0,4};
        System.out.println(minJumps(jumps,jumps.length));

    }
}
