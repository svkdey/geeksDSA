package Recursion;

public class TowerofHanoi {
	//
	public static void TOH(int n, String A, String B, String C ){
		// TODO Auto-generated method stub
		// A=source C=dest B=aux tower
		if (n == 1) {
			
			// when n==1 we can move a to c
			System.out.println("move " + n + " th tower " + A + " To " + C);
//			return;
			
		} else {
//			when n==n we can take n-1 top tower source to Aux tower thinking that Aux is our dest position
			// toh(n-1 tower, source , aux tower ,dest tower)
		
			TOH(n - 1, A, C, B);
//			n th disc moved to a to c
			System.out.println("move " + n + "th tower " + A + " To " + C);
			// now N-1 aux disc move to A
			
			TOH(n - 1, B, A, C);
//			System.out.println(i);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		TOH(2, "a", "b", "c");
		System.out.println(i);
	}

}
