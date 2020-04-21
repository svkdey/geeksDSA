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

	public static void SellAndBuyStockProblemtoGetMaxprofit3(int[] arr, int start, int end) {
		ArrayList<int[]> list=new ArrayList<int[]>();
		int [] transaction= {0,0};
		for(int i=0;i<end-1;i++) {
			if(arr[i+1]>arr[i]) {
				transaction[0]=arr[i];
				transaction[0]=arr[i+1];
				list.add(transaction);
			}
		}
		System.out.println(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] stocklist1 = { 1, 2, 10, 5, 2, 3, 12 };
//		System.out.println(SellAndBuyStockProblemtoGetMaxprofit(stocklist1, 0, 6));
//		int[] stocklist2 = { 1, 2, 3 };
//		System.out.println(SellAndBuyStockProblemtoGetMaxprofit(stocklist2, 0, 2));
//		int[] stocklist3 = { 3, 2, 1 };
//		System.out.println(SellAndBuyStockProblemtoGetMaxprofit(stocklist3, 0, 2));
		int[] stocklist4 = { 1, 1, 10, 10, 30, 5 };
		SellAndBuyStockProblemtoGetMaxprofit3(stocklist4, 0, 5);
	}

}
