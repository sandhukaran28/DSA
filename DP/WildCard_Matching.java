package dp;

import java.util.Arrays;

public class WildCard_Matching {

	public boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return sol(s, n, p, m, dp) == 1 ? true : false;
	}

	public int sol(String s, int n, String p, int m, int[][] dp) {

		if (n == 0) {

			if (m == 0) {
				return 1;
			}

			if (p.charAt(m - 1) != '*') {

				return 0;
			} else {

				return sol(s, n, p, m - 1, dp);
			}
		}
		if (m == 0) {
			return 0;
		}

		if (dp[n][m] != -1) {

			return dp[n][m];
		}

		if (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {

			int c0 = sol(s, n - 1, p, m - 1, dp);
			return dp[n][m] = c0;
		} else {

			if (p.charAt(m - 1) == '*') {

				int c1 = sol(s, n, p, m - 1, dp); // Match with empty
				int c2 = sol(s, n - 1, p, m, dp); // Match but not discard * yet

				return dp[n][m] = Math.max(c1, c2);

			} else {
				return 0;

			}

		}
	}

}
