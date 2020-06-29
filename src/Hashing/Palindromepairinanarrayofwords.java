package Hashing;

public class Palindromepairinanarrayofwords {
	static boolean palindrome(String s) {
		if(s=="") return false;
		int i=0,l=s.length()-1;
		while(l>i) {
			if(s.charAt(i)!=s.charAt(l)) {
				return false;
			}
			i++;l--;
		}
		return true;
	}
	
	//o(n^2*k) naive
	static int count=0;
	public static void solveAllCombination(String s[],int i,String op) {
		if(i==s.length) {
			if(palindrome(op)) {
				System.out.println(op);
				count++;
			}
			return;
		}
		solveAllCombination(s, i+1, op);
		solveAllCombination(s, i+1, op+s[i]);
	}
	public static void solveAllPermulation(String s[],int i) {
		if(i==s.length) {
			String op="";
			for(String x:s) {
				op+=x;
			}
			if(palindrome(op)) {
				System.out.println(op);
				count++;
			}
			return;
		}
		for(int j=i;j<s.length;j++) {
			swap(s,i,j);
			solveAllPermulation(s, i+1);
			swap(s,i,j);
		}
	}
	private static void swap(String arr[], int i, int j) {
		String t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[]= {"abcd","dcba","ll","s","ssll"};
//		int count=0;
		solveAllCombination(s,0,"");
		System.out.println(count);
		solveAllPermulation(s, 0);
		System.out.println(count);
	}

}
