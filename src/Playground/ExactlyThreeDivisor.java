package Playground;

public class ExactlyThreeDivisor {
	public static boolean isPrime(int num){
		System.out.println(num);
	    boolean isprime=true;
	    for(int i=2;i<num;i++) {
	    	if(i%2==0) {
	    		isprime=false;
	    		break;
	    	}
	    }
	    return isprime;
    }
	public static void exactly3divisor(int num) {
		int count=0;
		for(int i=4;i<num;i++) {
			double number = Math.sqrt(i);
			if(isPrime((int)number)){
			    count++;
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-----------------------");
		exactly3divisor(30);
	}
}
