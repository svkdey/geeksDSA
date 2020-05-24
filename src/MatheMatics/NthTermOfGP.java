package MatheMatics;

public class NthTermOfGP {

	public static int nthTerm(int a,int b,int n) {
		double r=(double)b/(double)a;
		double nThTerm=a*Math.pow(r, n-1);
		System.out.println((int)Math.floor(nThTerm));
		return (int)Math.floor(nThTerm);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nthTerm(84,87,3);
	}

}
