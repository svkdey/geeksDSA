package DPrevised.GridBasedProblem;

import java.util.Arrays;

//minimum cost to find 00, R-1,C-1
public class MinimumCostPath {
	/**
	 * dp[x,y]=min(dp[x-1][y],dp[x][y-1])+cost[x,y]
	 **/
	
	
	static int givenMatrix[][]= {{1,2,3,1},{2,3,0,2},{5,-1,2,4}};
	static int result[][]= null;
	public static void solveMiniMum() {
		result=new int[givenMatrix.length][givenMatrix[0].length];
		
		for(int x=0;x<givenMatrix.length;x++) {
			for(int y=0;y<givenMatrix[0].length;y++) {
				if(x==0&&y==0) {
					result[x][y]=givenMatrix[0][0];
				}
				else if(x==0) {
					result[x][y]=result[0][y-1]+givenMatrix[0][y];	
				}
				else if(y==0) {
					result[x][y]=result[x-1][0]+givenMatrix[x][0];
				}else {
					result[x][y]=Math.min(result[x][y-1],result[x-1][y])+givenMatrix[x][y];
				}
			}
		}
		for(int x=0;x<givenMatrix.length;x++) {
			System.out.println(Arrays.toString(result[x]));
		}
	}
	public static void solveMaximum() {
		result=new int[givenMatrix.length][givenMatrix[0].length];
		
		for(int x=0;x<givenMatrix.length;x++) {
			for(int y=0;y<givenMatrix[0].length;y++) {
				if(x==0&&y==0) {
					result[x][y]=givenMatrix[0][0];
				}
				else if(x==0) {
					result[x][y]=result[0][y-1]+givenMatrix[0][y];	
				}
				else if(y==0) {
					result[x][y]=result[x-1][0]+givenMatrix[x][0];
				}else {
					result[x][y]=Math.max(result[x][y-1],result[x-1][y])+givenMatrix[x][y];
				}
			}
		}
		for(int x=0;x<givenMatrix.length;x++) {
			System.out.println(Arrays.toString(result[x]));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveMiniMum();
		System.out.println("----------------------------------");
		solveMaximum();
	}

}
