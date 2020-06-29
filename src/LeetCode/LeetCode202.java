package LeetCode;

import CrackingTheCodingInterView.ArraysAndString.isUnique;

public class LeetCode202 {
	public static int makeHappy(int n){
        int a=0;
        
        while(n!=0){
            int val=(n%10);
            n=n/10;
            a+=Math.pow(val,2);
        }
       return a;
        
    }
    public static boolean isHappy(int n) {
    	int i=0;
        while(n!=1){
            int num=makeHappy(n);
            n=num;
            i++;
            if(i==1000) {
            	break;
            }
        }
        return n==1;
    }
    public static void main(String[] args) {
		System.out.println(isHappy(55));
	}
}
