package DPrevised.GridBasedProblem;

public class VacationProblem {
	static class Activity{
		int a,b,c;

		@Override
		public String toString() {
			return "Activity [a=" + a + ", b=" + b + ", c=" + c + "]";
		}

		public Activity(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
	}
	public static void solve(	Activity activity[],int n) {
		int dp[][]=new int[n][3];
		//if day ==0 ie initial work;
		dp[0][0]=activity[0].a;
		dp[0][1]=activity[0].b;
		dp[0][2]=activity[0].c;
		int ans=Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			dp[i][0]=activity[i].a+Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1]=activity[i].b+Math.max(dp[i-1][0], dp[i-1][2]);
			dp[i][2]=activity[i].c+Math.max(dp[i-1][1], dp[i-1][0]);
			
		}
		ans=Math.max(dp[n-1][0],Math.max(dp[n-1][1], Math.max(dp[n-1][2], ans)));
		System.out.println(ans);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity activity[]=new Activity[3];
		activity[0]=new Activity(10,40,70);
		activity[1]=new Activity(20,50,80);
		activity[2]=new Activity(30,60,90);
		solve(activity,3);
		
	}

}
