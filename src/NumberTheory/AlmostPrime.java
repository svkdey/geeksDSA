package NumberTheory;

import java.util.ArrayList;
import java.util.Arrays;

public class AlmostPrime {
	public static void solve(int n) {
		int isPrime[]=new int[n+1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);list.add(1);
		for(int factor=2;factor<=n;factor++) {
			if(isPrime[factor]==0) {
				list.add(factor); //list of numbers
//				System.out.print("list : ");
				for(int j=factor;j<=n;j+=factor) {
//					System.out.print(j*factor+" ");
					isPrime[j]=isPrime[j]+1;
				}
				
			}
			
		}
		System.out.println(Arrays.toString(isPrime));
		int ans=0;
		for(int x:isPrime) {
			if(x==2) {
				ans++;
			}
		}
		System.out.println(list);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		solve(21);
	}
}
