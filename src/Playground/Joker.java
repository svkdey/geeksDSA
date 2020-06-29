package Playground;

public class Joker {
    public static int solve(int n,int m ,int k) {
    	
    	
        if(m==0) return 0;
        if(n/k>m){
            int max=m;
            return max;
        }else{
            int max=m-n/k;
            int left=m-max;
            int remaining=left;
            if(left>1){
                int a=left%k-1;
                int b=left-(left%(k-1));
                 remaining=Math.max(a,b);
            }
//            System.out.println(remaining);
            return max-remaining;
        }
    }
    public static void solve() {

	}
   
}
