package dp;

public class Sell_Stock_With_Transaction {

	public int maxProfit(int[] prices, int fee) {
		int dp[][] = new int[prices.length][2];
		for (int i = 0; i < prices.length; i++) {

			dp[i][0] = -1;
			dp[i][1] = -1;
		}
		return sol(prices, 0, 1, fee, dp);
	}

	public int sol(int[] arr, int i, int k, int fee, int[][] dp) {

		if (i == arr.length) {

			return 0;
		}

		if (dp[i][k] != -1) {

			return dp[i][k];
		}

		if (k == 1) {

			int c1 = sol(arr, i + 1, 0, fee, dp) - (arr[i] + fee);
			int c2 = sol(arr, i + 1, k, fee, dp);

			return dp[i][k] = Math.max(c1, c2);
		} else {

			int c1 = sol(arr, i + 1, 1, fee, dp) + arr[i];
			int c2 = sol(arr, i + 1, k, fee, dp);

			return dp[i][k] = Math.max(c1, c2);
		}
	}

}
