package dp;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int e : nums) {
			sum += e;
		}

		if (sum % 2 != 0) {
			return false;
		}
		sum /= 2;

		int[][] dp = new int[nums.length][sum + 1];

		for (int i = 0; i < nums.length; i++) {

			Arrays.fill(dp[i], -1);

		}
		return sol(nums, sum, 0, dp) == 1 ? true : false;
	}

	public int sol(int[] arr, int sum, int i, int[][] dp) {

		if (sum == 0) {
			return 1;
		}

		if (i >= arr.length || sum < 0) {

			return 0;

		}

		if (dp[i][sum] != -1) {

			return dp[i][sum];
		}

		int c1 = sol(arr, sum - arr[i], i + 1, dp);
		int c2 = sol(arr, sum, i + 1, dp);

		return dp[i][sum] = Math.max(c1, c2);

	}

}
