package NumberTheory;

import java.util.ArrayList;

/**
 * n! 
 * ----- 
 * (k^x)
 * 
 * 
 * find x;
 * 
 * 
 **/

public class NumberOfFactorsInfactorials {
	
	public static void solve(int n, int k) {
		int occ=0,ans=Integer.MAX_VALUE;
		for(int i=2;i*i<=k;i++) {
			if(k%i==0) {
				occ=0;
				while(k%i==0) {
					occ++;
					k=k/i;
				}
			}
			
			int cnt=0;
			int p=i;
			
			while(p<=n) {
				cnt+=n/p;
				p=p*i;
			}
			ans=Math.min(ans, cnt/occ);
		}
		if(k>0) {
			int cnt=0;
			int p=k;
			
			while(p<=n) {
				cnt+=n/p;
				p=p*k;
			}
			ans=Math.min(ans, cnt);
		}
		if(ans==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(1000, 2);
	}

}
