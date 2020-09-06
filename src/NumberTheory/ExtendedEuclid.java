package NumberTheory;

/**
 * given eqtn Ax+By=gcd(A,B) so value x=? y=?
 * 
 * x = y’ || y = x’ – [A/B]y’
 * 
 * 
 * application multiplication module inverse linear diophantine eqtn
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 **/
//a>b
public class ExtendedEuclid {
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
	//application 1  getInverseModulo
	public static int findInverseModulo(int a,int mod) {
		if(GCD.gcd(a, mod)==1) {
			solve(a, mod);
			return (x+mod)%mod;
		}else {
			return Integer.MAX_VALUE;
		}
	}
	//{x,y} ={x1+(b/g)t;y1-(a/g)t} general solution
	public static void linerDiophantineEqueation(int a,int b,int c) {
		if(c%GCD.gcd(a, b)==0) {
			solve(a,b);
			System.out.println("x1 ->"+x+"---"+"y1 ->"+y);
		}else {
			System.out.println("no solution");
		}
	}
	
	public static void main(String[] args) {
		System.out.println();
		linerDiophantineEqueation(3,6,9);
	}
}
