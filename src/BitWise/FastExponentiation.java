package BitWise;

public class FastExponentiation {
	public static int power(int a, int b) {
		int ans = 1;
		while (b > 0) {
			int l_bit=(b&1);
			if(l_bit==1) {
				ans=a*ans;
			}
			a=a*a;
			b=b>>1;
			
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(3, 4));
	}

}
