package dp;

import java.util.Arrays;

public class Longest_Palindrone_Sequence {

	public int longestPalindromeSubseq(String s) {
		int dp[][] = new int[s.length() + 1][s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {

			Arrays.fill(dp[i], -1);
		}
		return sol(s, 0, s.length() - 1, dp);

	}

	public int sol(String s, int i, int j, int dp[][]) {

		if (i > j) {

			return 0;
		}

		if (i == j) {

			return 1;
		}

		if (dp[i][j] != -1) {

			return dp[i][j];
		}

		int c1 = 0;

		if (s.charAt(i) == s.charAt(j)) {

			c1 = sol(s, i + 1, j - 1, dp) + 2;
		}

		int c2 = sol(s, i + 1, j, dp);
		int c3 = sol(s, i, j - 1, dp);

		return dp[i][j] = Math.max(c1, Math.max(c2, c3));
	}

}
