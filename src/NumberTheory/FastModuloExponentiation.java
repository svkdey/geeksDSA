package NumberTheory;

public class FastModuloExponentiation {
	public static long fastExp(int a, int b,int mod) {
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = (res * a)%mod;
			}
			a=(a*a)%mod;
		
			b=b>>1;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(fastExp(5, 3,100));
	}
}
