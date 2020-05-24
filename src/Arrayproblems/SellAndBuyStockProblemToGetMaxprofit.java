package Arrayproblems;

import java.util.ArrayList;

public class SellAndBuyStockProblemToGetMaxprofit {
	/*
	 * Solution :1 we need to find a pair where transaction is profitable ,lets buy
	 * day is i and sell day is j . you need to find any other pair is there btwn
	 * starting to i-1 and j+1 to end day. so we need to do call recusive calls btwn
	 * starting to i-1 and j+1 to end day. there might be cases where btw i to j
	 * many profitable transaction happend. we need to find out max profit solution
	 * .
	 */
	public static int SellAndBuyStockProblemtoGetMaxprofit(int[] arr, int start, int end) {
		if (start >= end)
			return 0;
		int currentProfit = 0;
		int profit = 0;

		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (arr[j] > arr[i]) {
					// profit btwn j and i transaction + profit btwn start to i-1 transaction +
					// profit btwn j+1 to end transaction
					
					currentProfit = arr[j] - arr[i] + SellAndBuyStockProblemtoGetMaxprofit(arr, start, i - 1)
							+ SellAndBuyStockProblemtoGetMaxprofit(arr, j + 1, end);
					
					profit = Math.max(currentProfit, profit);
				}
			}
		}
//		System.out.println(profit); 
		return profit;
	}

	/*
	 * Solution :2 by observation we can say when stock price rate changes to +ve
	 * slope we will start buying and then if +ve curve maintained then we let it
	 * keep growing . when we see it turns a -ve slope we sell it. and repeat this
	 * process
	 * 
	 *
	 */
	public static int SellAndBuyStockProblemtoGetMaxprofit2(int[] arr, int start, int end) {
		int profit = 0;
		for (int i = 1; i < end; i++) {
			if (arr[i] > arr[i - 1]) {
				// cumulative addition: c-a => b-a+c-b
				profit += arr[i] - arr[i - 1];
			}
		}
		return profit;

	}
	static class Interval {
		int buy, sell;
	}
//int[] stocklist4 = { 23, 13, 25, 29, 33, 19, 34, 45, 65, 67 };
	public static void SellAndBuyStockProblemtoGetMaxprofit3(int[] price,int n) {
		if (n == 1) {
			System.out.println("No Profit");
			return;
		}
		int count = 0;
		// Traverse through given price array
		int i = 0;
		while (i < n - 1) {
			//for ith transcation start
			// Find Local Minima. Note that the limit is (n-2) as we are
			// comparing present element to the next element.
			//

			while ((i < n - 1) && (price[i + 1] <= price[i])) {
				i++;
			}
			// If we reached the end, break as no further solution possible
			if (i == n - 1)
				break;

			Interval e = new Interval();
			e.buy = i++;
			// Store the index of minima

			// Find Local Maxima.  Note that the limit is (n-1) as we are
			// comparing to previous element

			while ((i < n) && (price[i] >= price[i - 1])) {
				i++;
			}
			// Store the index of maxima
			e.sell = i - 1;
//			sol.add(e);
			System.out.println("Buy on day: " + e.buy
					+ "        "
					+ "Sell on day : " + e.sell);
			// Increment number of buy/sell
			count++;
		}

		// print solution
		if (count == 0)
			System.out.println("No Profit");
		else{

		}

		return;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] stocklist1 = { 1, 2, 10, 5, 2, 3, 12 };
//		System.out.println(SellAndBuyStockProblemtoGetMaxprofit(stocklist1, 0, 6));
//		int[] stocklist2 = { 1, 2, 3 };
//		System.out.println(SellAndBuyStockProblemtoGetMaxprofit(stocklist2, 0, 2));
//		int[] stocklist3 = { 3, 2, 1 };
//		System.out.println(SellAndBuyStockProblemtoGetMaxprofit(stocklist3, 0, 2));
		int[] stocklist4 = { 100, 180, 260, 310, 40, 535, 300 };
		int[] stocklist5 = { 5,5,5,5,5};
		SellAndBuyStockProblemtoGetMaxprofit3(stocklist4, stocklist4.length);
	}

}
