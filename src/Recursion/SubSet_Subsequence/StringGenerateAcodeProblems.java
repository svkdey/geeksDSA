package Recursion.SubSet_Subsequence;

import java.util.ArrayList;
//permuation problem
public class StringGenerateAcodeProblems {
	
	public static void solve(int in[],int i,ArrayList<Character> op) {
		if(i==in.length) {
			System.out.println(op);
			return;
		}
		int digit=in[i];
		if(digit!=0) {
		char c=(char)(digit+96);
		op.add(c);}
//	one digit at a time	
		solve(in, i+1, op);
		op.remove(op.size()-1);
		
		//2 digit at a time
		if(i+1<in.length) {
			int secondDigit=in[i+1];
//			if(digit!=0) {
			int no=digit*10+secondDigit;
//			System.out.println(no);
			if(no<=26) {
				char d=(char)(96+no);
				op.add(d);
				solve(in, i+2, op);
				op.remove(op.size()-1);
			}
		}
			
			


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[]= {1,2,3,};
		ArrayList<Character> list = new ArrayList<Character>();
		solve(in, 0,list);
	}

}
