package dp;

import java.util.Arrays;

public class LIS {

	public int lengthOfLIS(int[] nums) {

		int dp[][] = new int[nums.length + 1][nums.length + 1];

		for (int i = 0; i <= nums.length; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		return len(nums, 0, -1, dp);
	}

	public int len(int[] arr, int curr, int prev, int[][] dp) {

		if (curr >= arr.length) {

			return 0;
		}

		if (dp[curr + 1][prev + 1] != Integer.MIN_VALUE) {

			return dp[curr + 1][prev + 1];
		}
		int c1 = 0;
		if (prev == -1 || arr[curr] > arr[prev])
			c1 = len(arr, curr + 1, curr, dp) + 1;
		int c2 = len(arr, curr + 1, prev, dp);

		return dp[curr + 1][prev + 1] = Math.max(c1, c2);

	}
}
