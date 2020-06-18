package Recursion;

public class FourNTiles {
	static int TileNumber(int n){
	    if(n==0) return 0;
	    if(n>0&&n<4) return 1;
	    if(n==4) return 2;
	    else{
	       return  TileNumber(n-1)+TileNumber(n-4);
	    }

	}
	public static void solve() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
