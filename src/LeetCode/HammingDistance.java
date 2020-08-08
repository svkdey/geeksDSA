package LeetCode;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
        int xor=x^y;
        int ans=0;
        while(xor!=0){
            if((xor&1)==1){
                ans++;
            }
            xor=xor>>>1;
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
