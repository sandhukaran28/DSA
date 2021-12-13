package dp;

import java.util.Arrays;

public class Minimum_ASCII_delete_Sum {

	public int minimumDeleteSum(String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {

			Arrays.fill(dp[i], -1);
		}
		return sol(s1, s1.length(), s2, s2.length(), dp);
	}

	public int sol(String s1, int i, String s2, int j, int[][] dp) {

		if (i == 0 && j == 0) {

			return 0;
		}

		if (i == 0) {

			return dp[i][j] = sol(s1, i, s2, j - 1, dp) + s2.charAt(j - 1);
		}
		if (j == 0) {

			return dp[i][j] = sol(s1, i - 1, s2, j, dp) + s1.charAt(i - 1);
		}

		if (dp[i][j] != -1) {

			return dp[i][j];
		}

		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

			return dp[i][j] = sol(s1, i - 1, s2, j - 1, dp);
		}

		int c1 = sol(s1, i - 1, s2, j, dp) + s1.charAt(i - 1);
		int c2 = sol(s1, i, s2, j - 1, dp) + s2.charAt(j - 1);

		return dp[i][j] = Math.min(c1, c2);
	}

}
