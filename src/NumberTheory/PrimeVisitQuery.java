package NumberTheory;

import java.util.Arrays;

public class PrimeVisitQuery {
	boolean isPrime[] = null;
	long range_A = 0;
	long range_B = 0;

	public PrimeVisitQuery(int a, int b) {
		this.range_A = a;
		this.range_B = b;
		this.isPrime = new boolean[b + 1];
		
		compute();
	}

	private void compute() {
		for (int i = 1; i <= (int) this.range_B; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i <= Math.sqrt(this.range_B); i++) {
			if (isPrime[i]) {
				for (int j = i; j*i <= this.range_B; j++) {
					isPrime[j*i] = false;
				}
			}
		}
		System.out.println(Arrays.toString(isPrime));
	}
	public void Query(int l,int r) {
		int count=0;
		for(int i=l;i<=r;i++) {
			if(isPrime[i]==true) {
				count++;
			}
		}
		System.out.println(count);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeVisitQuery pvq=new PrimeVisitQuery(0, 100);
		pvq.Query(2,10);
	}

}
