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
	static boolean checkIfAllnumberPrime(String s) {
		if("4".equals(s)||"6".equals(s)||"8".equals(s)||"9".equals(s)) {return false;}
		else {
		
		for(int i=0;i<s.length();i++) {
			String sub=s.substring(i, i+1);
			if(!(sub.contains("2")||sub.contains("3")||sub.contains("7")||sub.contains("5"))){
				return false;
			}
		}
		return true;
		}
	}
	 static void getNumber(int num){
	        int count=1;
	        int i=3;
	        while(count!=num){
	        	String val=Integer.toString(i);
	        	if(checkIfAllnumberPrime(val)) {
//	        		System.out.println(val);
	        		count++;
	        	}
	        	i++;
	        }
	        System.out.println(i-1);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-----------------------");
//		exactly3divisor(30);
		getNumber(10);
	}
}
