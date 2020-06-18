package Recursion;

public class TowerofHanoi {
	// a =start b=aux c=start
	public static void solve(int n, char a, char b, char c) {
		if (n == 1) {
			System.out.println(n + " th disc " + a + " to " + c);
		} else {
			// n-1 disc will be a -> b first
			solve(n - 1, a, c, b);
			// move n th disc to a to c
			System.out.println(n + " th disc " + a + " to " + c);
			// rest n-1 will be moved to c form b
			solve(n - 1, b, a, c);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(8, 'a', 'b', 'c');
	}

}
