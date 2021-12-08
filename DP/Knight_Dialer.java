package dp;

import java.util.Arrays;

public class Knight_Dialer {

	public int MOD = 1000000007;
	int row[] = { -2, -1, -2, -1, 2, 1, 1, 2 };
	int col[] = { -1, -2, 1, 2, -1, -2, 2, 1 };

	public int knightDialer(int n) {

		int dp[][][] = new int[4][3][n + 1];
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 3; j++) {

				Arrays.fill(dp[i][j], -1);
			}
		}
		int ans = 0;
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 3; j++) {

				ans = (ans + sol(i, j, n - 1, dp)) % MOD;
			}
		}
		return ans % MOD;
	}

	public int sol(int r, int c, int k, int[][][] dp) {

		if (r < 0 || r >= 4 || c < 0 || c >= 3 || (r == 3 && c == 0) || (r == 3 && c == 2)) {

			return 0;
		}
		if (k == 0) {
			return 1;
		}

		if (dp[r][c][k] != -1) {

			return dp[r][c][k];
		}

		int ans = 0;
		for (int i = 0; i < 8; i++) {

			ans = (ans + sol(r + row[i], c + col[i], k - 1, dp)) % MOD;
		}

		return dp[r][c][k] = ans % MOD;
	}

}
