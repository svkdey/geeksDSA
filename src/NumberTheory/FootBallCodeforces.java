package NumberTheory;

public class FootBallCodeforces {
	static int x=0;
	static int y=0;
	static int gcd=0;
	public static void solve(int a,int b) {
		if(b==0) {
			x=1;
			y=0;
			gcd=a;
			return;
		}
		solve(b,a%b);
		
		int cX=y;
		int cY=x-(int)Math.floor(a/b)*y;
		
		
		x=cX;
		y=cY;
	}
	public static int findInverseModulo(int a,int mod) {
		if(GCD.gcd(a, mod)==1) {
			solve(a, mod);
			return (x+mod)%mod;
		}else {
			return Integer.MAX_VALUE;
		}
	}
	public static void footballSolve(int n,int p,int w,int d) {
		if(n*w<p) {
			System.out.println("no solution");
		}
		else if(p%GCD.gcd(w, d)!=0) {
			System.out.println("no solution");
			
		}else {
			int g=GCD.gcd(w, d);
			p=p/g;w=w/g;d=d/g;
			int a=((p%w)*findInverseModulo(d, w))%w;
			int b=(p-(y*d))/w;
			int c=n-a-b;
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}
	public static void main(String[] args) {
		
		footballSolve(30,60,3,1);
	}
	
}
