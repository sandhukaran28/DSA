package dp;

import java.util.Arrays;

public class Sell_Stock_IV {

	public int maxProfit(int k, int[] prices) {
		int[][][] dp = new int[prices.length][2][k];

		for (int i = 0; i < prices.length; i++) {

			for (int j = 0; j < 2; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		return sol(prices, 1, 0, 0, k, dp);
	}

	public int sol(int[] arr, int buy, int k, int curr, int target, int[][][] dp) {

		if (k == target || curr >= arr.length) {
			return 0;
		}

		if (dp[curr][buy][k] != -1) {

			return dp[curr][buy][k];
		}
		if (buy == 1) {

			int c1 = sol(arr, 0, k, curr + 1, target, dp) - arr[curr]; // Buy
			int c2 = sol(arr, buy, k, curr + 1, target, dp); // Dont't buy

			return dp[curr][buy][k] = Math.max(c1, c2);
		} else {

			int c1 = sol(arr, 1, k + 1, curr + 1, target, dp) + arr[curr]; // Sell
			int c2 = sol(arr, buy, k, curr + 1, target, dp); // Don't sell

			return dp[curr][buy][k] = Math.max(c1, c2);
		}
	}

}
