package LeetCode;

public class LeetCode67 {
	public static int toDecimal(String s) {
		char c[]=s.toCharArray();
		int ans=0;
		int idx=0;
		for(int i=c.length-1;i>=0;i--) {
			ans+=((int)(c[i]-'0'))*Math.pow(2, idx++);
			;
		}
		return ans;
	}
	 public static String addBinary(String a, String b) {
	        int x=toDecimal(a);
	        int y=toDecimal(b);
	        return Integer.toBinaryString(x+y);
	    }
	 public static void main(String[] args) {
		String a="11";
		String b="1";
		System.out.println(addBinary(a, b));
	}
}
