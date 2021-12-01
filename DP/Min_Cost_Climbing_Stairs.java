package DP;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {

	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		return Math.min(sol(cost, 0, dp), sol(cost, 1, dp));
	}

	public int sol(int[] cost, int n, int[] dp) {

		if (n >= cost.length) {
			return 0;
		}

		if (dp[n] != -1) {

			return dp[n];
		}

		int c1 = sol(cost, n + 1, dp);
		int c2 = sol(cost, n + 2, dp);

		return dp[n] = Math.min(c1, c2) + cost[n];
	}

}
