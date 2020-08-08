package DPrevised;

public class WinesProblem {
	static int totalPrice[][] = null;
	
	public static int solve(int prices[], int i, int j, int total, int year) {
		if (i>j) {

			return 0;

		}
		if(totalPrice[i][j]!=0) {
			return totalPrice[i][j];
		}
		
		int op1=(prices[i] * year)+solve(prices, i+1, j, total, year+1);
		int op2=(prices[j] * year)+solve(prices, i, j-1, total, year+1);
		
		totalPrice[i][j]= Math.max(op1,op2);
		return totalPrice[i][j];
		 
	}

	public static void main(String[] args) {

		int prices[] = { 2, 3, 5, 1, 4 };
		int total = 0;
		int j = prices.length - 1;
		int year = 1;
		totalPrice=new int[100][100];
		System.out.println(solve(prices, 0, j, total, year));
		System.out.println(Math.random()*10);
	}
}
