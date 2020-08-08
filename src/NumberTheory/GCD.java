package NumberTheory;
/**
 * for a>b gcd(a,b)=gcd(b,a%b)
 * 			if(b==0) return a;
 * 
 * HCF==GCD
 * LCM=(a*b)/gcd(a,b) ;
 * 
 * 
 * o(n)= o(ln(a))
 * 
 * 
 * 
 * **/





public class GCD {
	//a>=b
	public static int gcd(int a,int b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
	//a>=b
	public static int lcm(int a,int b) {
		return (a*b)/gcd(a,b);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
