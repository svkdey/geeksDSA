package Algorithms.GreedyBasic;

import java.util.Arrays;

//code forces , chopsticks

public class Chopstick {
	public static void solve(int chopsticks[],int n,int D) {
		Arrays.toString(chopsticks);
		
		int count=0;
		
		for(int i=1;i<n;) {
			if(chopsticks[i]-chopsticks[i-1]<=D) {
				count++;
				i=i+2;
				
			}else {
				i++;
			}
		}
		System.out.println(count);
		
	}
	
	public static void main(String[] args) {
		int c[]= {1,3,3,9,4};
		solve(c, c.length, 2);
	}
}
