package dp;

public class Sell_Stock_II {

	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];

		for (int i = 0; i < prices.length; i++) {

			dp[i][0] = -1;
			dp[i][1] = -1;
		}
		return sol(prices, 1, 0, dp);
	}

	public int sol(int[] arr, int buy, int curr, int[][] dp) {

		if (curr >= arr.length) {
			return 0;
		}

		if (dp[curr][buy] != -1) {

			return dp[curr][buy];
		}
		if (buy == 1) {

			int c1 = sol(arr, 0, curr + 1, dp) - arr[curr]; // Buy
			int c2 = sol(arr, buy, curr + 1, dp); // Dont't buy

			return dp[curr][buy] = Math.max(c1, c2);
		} else {

			int c1 = sol(arr, 1, curr + 1, dp) + arr[curr]; // Sell
			int c2 = sol(arr, buy, curr + 1, dp); // Don't sell

			return dp[curr][buy] = Math.max(c1, c2);
		}
	}

}
