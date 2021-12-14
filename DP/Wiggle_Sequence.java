package dp;

import java.util.Arrays;

public class Wiggle_Sequence {

	public int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n][3];

		for (int i = 0; i < n; i++) {

			Arrays.fill(dp[i], -1);
		}

		if (n == 1) {
			return 1;
		} else if (n == 2) {

			if (nums[0] != nums[1]) {
				return 0;
			}
			return 1;
		}

		return sol(nums, 1, 0, 1, dp);
	}

	public int sol(int[] arr, int i, int flag, int curr, int[][] dp) {

		if (i == arr.length) {

			return curr;
		}

		if (dp[i][flag + 1] != -1) {

			return dp[i][flag + 1];
		}

		int cDiff = arr[i] - arr[i - 1];
		int cFlag = cDiff > 0 ? 1 : cDiff == 0 ? 0 : -1;
		int c1 = 0;
		if (flag == 0 || (flag == 1 && cDiff < 0) || (flag == -1 && cDiff > 0)) {
			if (cFlag != 0)
				c1 = sol(arr, i + 1, cFlag, curr + 1, dp);
			else
				c1 = sol(arr, i + 1, cFlag, curr, dp);
		}
		int c2 = sol(arr, i + 1, flag, curr, dp);

		return dp[i][flag + 1] = Math.max(c1, c2);
	}

}
