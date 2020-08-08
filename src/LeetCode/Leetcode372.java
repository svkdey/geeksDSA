package LeetCode;

public class Leetcode372 {
	public int superPow(int a, int[] b) {
        int bv=0;
        int k=b.length-1;
        for(int i=b.length-1;i>=0;i--){
            bv+=b[i]*(int)Math.pow(10,(k-i));
        }
        System.out.print(bv);
        long val=((long)Math.pow(a,bv))%1337;
        return (int)val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
