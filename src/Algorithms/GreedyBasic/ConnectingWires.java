package Algorithms.GreedyBasic;

import java.util.Arrays;

/**
 * How would you design a greedy algorithm which connects 
 * each black dot with a white dot so that the total length 
 * of wires used to form such connected pairs is minimal?
 * 
 * 
 * **/
public class ConnectingWires {
	public static int solve(int w[],int b[]) {
		Arrays.sort(w);Arrays.sort(b);
		
		int len=0;
		for(int i=0;i<w.length;i++) {
			len+=Math.abs(w[i]-b[i]);
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int whitePos[]= {3,4,1};
		int blackPos[]= {2,5,6};
		
		System.out.println(solve(whitePos, blackPos));
	}

}
