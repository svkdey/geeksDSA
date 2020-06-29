package Algorithms.GreedyBasic;

import java.util.Arrays;
import java.util.Comparator;

//https://www.spoj.com/problems/DEFKIN/
public class ProtectTheKingDom {
	static class Position {
		int x, y;

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	// position arr =co ordinates of tower . l,w,h=len,width,height
	public static void solve(int x[],int y[], int n, int l, int w, int h) {
		
	
		Arrays.sort(x);
		Arrays.sort(y);
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));
		//first area
		int maxX = x[0]-1;
		int maxY = y[0]-1;
//		System.out.println(maxX+" "+maxY);
		int i = 0;
		//middle area
		for (i = 1; i < n; i++) {
			maxX = Math.max(maxX, Math.abs(x[i - 1] - x[i]) - 1);
			maxY = Math.max(maxY, Math.abs(y[i - 1]- y[i]) - 1);
		}
//		System.out.println(maxX+" "+maxY);
		//last area
		maxX = Math.max(maxX, Math.abs(l - x[n - 1]));
		maxY = Math.max(maxY, Math.abs(w - y[n - 1]));
		System.out.println(maxX+" "+maxY);
		System.out.println(maxX * maxY);
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int x[]= {3,11,8};
		int y[]= {8,2,6};
		int l=15,w=8,h=3;
		solve(x,y, 3, l, w, h);
	}

}
