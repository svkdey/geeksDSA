package LeetCode;

public class LeetCode371 {
	public static int getSum(int a, int b) {
		if(a==0) return b;
		if(b==0) return a;
		return getSum(a^b, (a&b)<<1);
		
	}
	public static void main(String[] args) {
		System.out.println(getSum(3, 5));
	}
}
