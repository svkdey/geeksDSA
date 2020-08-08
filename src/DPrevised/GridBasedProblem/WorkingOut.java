package DPrevised.GridBasedProblem;

public class WorkingOut {
	public static void solve(int calories[][],int n,int m) {
		int boyStart[][]=new int[100][100];
		int girlStart[][]=new int[100][100];
		int boyEnd[][]=new int[100][100];
		int girlEnd[][]=new int[100][100];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				boyStart[i][j]=calories[i][j]+Math.max(boyStart[i-1][j],boyStart[i][j-1]);
			}
		}
		
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=m;j++) {
				girlStart[i][j]=calories[i][j]+Math.max(girlStart[i+1][j],girlStart[i][j-1]);
			}
		}
		
		for(int i=n;i>=1;i--) {
			for(int j=m;j>=1;j--) {
				boyEnd[i][j]=calories[i][j]+Math.max(boyEnd[i+1][j],boyEnd[i][j+1]);
			}
		}
		
		
		for(int i=1;i<=n;i++) {
			for(int j=m;j>=1;j--) {
				girlEnd[i][j]=calories[i][j]+Math.max(girlEnd[i-1][j],girlEnd[i][j+1]);
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int i=2;i<n;i++) {
			for(int j=2;j<m;j++) {
				int ans1=boyStart[i][j-1]+boyEnd[i][j+1]+girlStart[i+1][j]
						+girlStart[i-1][j];
				int ans2=boyStart[i-1][j]+boyEnd[i+1][j]+girlStart[i][j-1]
						+girlStart[i][j+1];		
				ans=Math.max(ans, Math.max(ans1, ans2));	
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
