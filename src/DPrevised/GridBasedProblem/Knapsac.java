package DPrevised.GridBasedProblem;

import java.util.Arrays;

public class Knapsac {
	static class Item {
		int weight;
		int volume;

		@Override
		public String toString() {
			return "Item [weight=" + weight + ", volume=" + volume + "]";
		}

		public Item(int weight, int volume) {
			super();
			this.weight = weight;
			this.volume = volume;
		}

	}

	static int memo[][] = null;

	public static int solve(Item items[], int targetWeight, int itemIdxNumber) {
		if (targetWeight < 0 || itemIdxNumber < 0)
			return 0;
		if (memo[targetWeight][itemIdxNumber] != -1) {
			return memo[targetWeight][itemIdxNumber];
		}
		int includeVolume = 0, excludeVolume = 0;
		if (targetWeight - items[itemIdxNumber].weight >= 0) {
			includeVolume = items[itemIdxNumber].volume
					+ solve(items, targetWeight - items[itemIdxNumber].weight, itemIdxNumber - 1);
		}
		excludeVolume = solve(items, targetWeight, itemIdxNumber - 1);
		memo[targetWeight][itemIdxNumber] = Math.max(includeVolume, excludeVolume);
		return memo[targetWeight][itemIdxNumber];

	}

	public static int bottomUp(Item items[], int W, int n) {
		int vol[] = new int[n];
		int wt[] = new int[n];
		int idx = 0;
		for (Item item : items) {
			vol[idx] = item.volume;
			wt[idx] = item.weight;
			idx++;
		}
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(vol[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}

	public static void main(String[] args) {

		Item items[] = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
		int W = 50;
		int n = items.length;
//        memo=new int[W+1][n+1];
//		for(int i=0;i<W+1;i++) {
//			Arrays.fill(memo[i], -1);
//		}
		System.out.println(bottomUp(items, W, n));
	}

}
