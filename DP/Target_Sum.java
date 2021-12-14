package dp;

import java.util.Arrays;

public class Target_Sum {

	public int findTargetSumWays(int[] nums, int target) {
		int dp[][] = new int[nums.length + 1][2002];
		for (int i = 0; i <= nums.length; i++) {

			Arrays.fill(dp[i], -1);
		}
		return sol(nums, 0, target, 0, dp);
	}

	public int sol(int[] arr, int i, int tSum, int cSum, int[][] dp) {

		if (i == arr.length) {

			if (tSum == cSum) {

				return 1;
			}
			return 0;
		}

		if (dp[i][1000 + cSum] != -1) {

			return dp[i][1000 + cSum];
		}
		int c1 = sol(arr, i + 1, tSum, cSum + arr[i], dp);
		int c2 = sol(arr, i + 1, tSum, cSum - arr[i], dp);

		return dp[i][1000 + cSum] = c1 + c2;

	}
}
