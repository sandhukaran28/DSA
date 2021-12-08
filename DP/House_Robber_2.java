package dp;

import java.util.Arrays;

public class House_Robber_2 {

	public int rob(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		if (n == 1) {
			return nums[0];
		}
		return Math.max(sol(nums, n - 1, 1, dp), sol(nums, n - 2, 0, dp));
	}

	public int sol(int[] nums, int n, int flag, int[][] dp) {

		if (flag == 1 && n == 0) {
			return 0;
		}

		if (n < 0) {
			return 0;
		}

		if (dp[n][flag] != -1) {
			return dp[n][flag];
		}

		int c1 = sol(nums, n - 2, flag, dp) + nums[n];
		int c2 = sol(nums, n - 1, flag, dp);

		return dp[n][flag] = Math.max(c1, c2);
	}

}
