package LeetCode;

public class July1 {
	 public int arrangeCoins(int n) {
	        int ans=0;
	        int step=1;
	        int coins=n;
	        for(int i=1;i<=n;i++){
	           if(coins>=step){
	               ans++;
	               coins=coins-i;
	               step++;
	               
	           }else{
	               break;
	           }
	            
	        }
	        System.out.println(ans);
	        return ans;
	    }
	 public static void main(String[] args) {
		July1 s=new July1();
		s.arrangeCoins(1);
	}
}
