package dp;

import java.util.Arrays;

public class Domino_And_Tromino_Tilling {

	int empty = 0;
	int upper = 1;
	int lower = 2;
	long MOD = 1000000007;

	public int numTilings(int n) {

		long dp[][] = new long[n + 1][3];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return (int) sol(n, 0, dp);
	}

	public long sol(int n, int state, long[][] dp) {

		if (n < 0) {
			return 0;
		}

		if (n == 0 && state == 0) {
			return 1;
		}
		if (dp[n][state] != -1) {
			return dp[n][state];
		}

		long c1 = 0, c2 = 0, c3 = 0;
		if (state == 0) {

			c1 = (sol(n - 1, 0, dp) + sol(n - 2, 0, dp) + sol(n - 1, 1, dp) + sol(n - 1, 2, dp)) % MOD;
		} else if (state == 1) {

			c2 = (sol(n - 1, 2, dp) + sol(n - 2, 0, dp)) % MOD;
		} else {

			c3 = (sol(n - 1, 1, dp) + sol(n - 2, 0, dp)) % MOD;
		}

		return dp[n][state] = (c1 + c2 + c3) % MOD;
	}

}
