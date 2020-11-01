package exam;

public class Demo {
	 public static void fizzBuzz(int n) {
		    // Write your code here
		        for(int i=0;i<=n;i++){
		            if(i%3==0&&i%5==0) {
		            	System.out.println("FizzBuzz");
		            }
		            else if(i%3==0) {
		            	System.out.println("Fizz");
		            }else if(i%5==0) {
		            	System.out.println("Buzz");
		            }else {
		            	System.out.println(i);
		            }
		        }
		    }
}
