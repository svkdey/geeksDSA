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
	public static void main(String[] args) {
		solve(18, 30);
		System.out.println(x+" "+y);
	}
}
